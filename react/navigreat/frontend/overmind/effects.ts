export { default as http } from "axios";
import axios from "axios";
import * as DocumentPicker from "expo-document-picker";

// TODO remove later on when not in dev
const server = "http://localhost:8080/api";

function getBase64(file) {
  const reader = new FileReader();
  reader.readAsDataURL(file);
  return reader.result;
}

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
    // TODO proper ID mapping; room has an `_id` value?
    let id = 0;
    const rooms = this.request
      .get(`${this.server}/rooms`)
      .then((response) => {
        console.log(response);
        const rooms = response.data._embedded.rooms.map((r: { name: any }) => {
          return {
            id: id++,
            name: r.name,
            // TODO more rooms data as desired.
          };
        });
        return rooms;
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
  async createRoom(title, file) {
    var data = new FormData();
    data.append("title", title);

    fetch(file.uri).then((res) =>
      res.blob().then((blob) => {
        data.append("image", blob, title);
        // TODO abstract `axios`? may be unnecessary
        axios
          .post(`${this.server}/photos`, data)
          .then((res) => {
            console.log(res);
          })
          .catch((err) => console.log(err));
      })
    );
  }
}

export const api = new API(server, axios);
