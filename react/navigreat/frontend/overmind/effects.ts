export { default as http } from "axios";
import axios from "axios";
import * as DocumentPicker from "expo-document-picker";
import { Form } from "native-base";
import { createRoom } from "./actions";

// TODO remove later on when not in dev
const server = "http://localhost:8080/api";

export class API {
  private app;
  private server;
  private request;

  constructor(server, request) {
    this.server = server;
    this.request = request;
  }

  // ? Maps the rooms data to an array of values.
  async updateRooms() {
    const rooms = axios
      .get(`${this.server}/rooms`)
      .then((response) => {
        // console.log(response)
        return response.data;
      })
      .catch((err) => console.log(err));
    return rooms;
  }

  async pickFile() {
    try {
      const photo = await DocumentPicker.getDocumentAsync({
        type: "image/*",
      });
      return photo;
    } catch (err) {
      throw err;
    }
  }

  // ? POSTs a room object to the DB.
  // ? takes a title String and file from DocumentPicker.
  // ? returns the MongoDB id of the file object.
  async uploadPhoto(title, file) {
    var data = new FormData();
    data.append("title", title);

    // uploads the selected image and returns it as the id
    fetch(file.uri).then((res) =>
      res.blob().then((blob) => {
        data.append("image", blob, title);
        // TODO abstract `axios`? may be unnecessary
        axios
          .post(`${this.server}/photos`, data)
          .then((res) => {
            return res.data;
          })
          .catch((err) => console.log(err));
      })
    );
  }

  async postRoom(payload) {
    console.log(JSON.stringify(payload));

    // then, need to still create the room
    axios
      .post(`${this.server}/rooms`, payload)
      .then((res) => {
        console.log(res);
      })
      .catch((err) => {
        console.log(err);
      });
  }
}

export const api = new API(server, axios);
