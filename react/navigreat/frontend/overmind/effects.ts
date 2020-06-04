export { default as http } from "axios";
import axios from "axios";
import * as DocumentPicker from "expo-document-picker";

// TODO remove later on when not in dev
const server = "http://localhost:8080";

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
  updateRooms = () => {
    // TODO proper ID mapping; room has an `_id` value?
    let id = 0;
    const rooms = this.request.get(`${this.server}/rooms`).then((response) => {
      const rooms = response.data._embedded.rooms.map((r: { name: any }) => {
        return {
          id: id++,
          name: r.name,
          // TODO more rooms data as desired.
        };
      });
      return rooms;
    });
    return rooms;
  };

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
  // ? takes a title String and an image file.
  async createRoom(title, file) {
    console.log(file);

    var data = new FormData();

    // var data = getBase64(file)

    data.append("title", title);
    // TODO this Blob is failing me... shrinking the size to 15
    data.append("image", title); //new Blob([file], { type: "image" }));
    console.log(...data);

    // TODO abstract `axios`? may be unnecessary
    axios
      .post(`${this.server}/photos/add`, data, {
        headers: {
          "Content-Type": "multipart/form-data",
        },
      })
      .then((res) => {
        console.log(res);
        // var img = new Image();
        // img.src = 'data:image/png;base64,' + res;
        // console.log(img);
        // return img;
      })

      .catch((err) => console.log(err));
  }
}

export const api = new API(server, axios);
