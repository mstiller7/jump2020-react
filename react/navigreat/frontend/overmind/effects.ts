export { default as http } from "axios";
import axios from "axios";
import DocumentPicker from "react-native-document-picker";

const server = "http://localhost:8080";

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

  pickFile = async () => {
    try {
      const photo = await DocumentPicker.pick({
        type: [DocumentPicker.types.images],
      });
      console.log(photo.uri, photo.type, photo.name, photo.size);
      return photo;
    } catch (err) {
      if (DocumentPicker.isCancel(err)) {
        // user cancelled, exit and continue
      } else {
        throw err;
      }
    }
  };

  // ? POSTs a room object to the DB.
  // ? takes a title String and an image file.
  createRoom = (title, image) => {
    var data = new FormData();
    data.set("title", title);
    data.append("image", image);

    this.request({
      method: "post",
      url: `${this.server}/photos/add`,
      data: data,
      headers: { "Content-Type": "multipart/form-data" },
    })
      .then(function (response) {
        console.log(response);
      })
      .catch(function (response) {
        console.log(response);
      });
  };
}

export const api = new API(server, axios);
