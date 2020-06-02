export { default as http } from "axios";
import axios from "axios";
// import DocumentPicker from "react-native-document-picker";
import * as DocumentPicker from "expo-document-picker";
// import { v4 as uuidv4 } from 'uuid';

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

  async pickFile() {
    // try {
    //   const photo = await DocumentPicker.pick({
    //     type: [DocumentPicker.types.images],
    //   });
    //   console.log(photo.uri, photo.type, photo.name, photo.size);
    //   return photo;
    // } catch (err) {
    //   throw err;
    // }
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
  createRoom = (title, image) => {
    var data = new FormData();
    data.append("title", title);
    data.append("image", new Blob([image], { type: "image" }));
    console.log(...data);

    // const config = {
    //   headers: {
    //     "content-type": "multipart/form-data",
    //   },
    // };

    // axios.interceptors.request.use( => {
    //   console.log(request);
    // })

    axios
      .post(`${this.server}/photos/add`, data)
      .then((res) => console.log(res))
      .catch((err) => console.log(err));

    // this.request({
    //   method: "post",
    //   url: `${this.server}/photos/add`,
    //   data: body,
    //   // headers: { "Content-Type": `multipart/form-data; boundary=${body._boundary}` },
    // })
    //   .then(function (response) {
    //     console.log(response);
    //   })
    //   .catch(function (response) {
    //     console.log(response);
    //   });
  };
}

export const api = new API(server, axios);
