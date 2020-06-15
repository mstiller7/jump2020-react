export { default as http } from "axios";
import axios from "axios";
import * as DocumentPicker from "expo-document-picker";

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

  /**
   * Makes a GET request to obtain the current list of rooms.
   */
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

  /**
   * Utilizes a document picked dialog to choose a file for upload.
   */
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

  /**
   * Makes a POST request to the webserver containing the file.
   * @param {String} title Name of file.
   * @param file File to be sent.
   * @fires axios.post()
   * @return The MongoDB ID String of the uploaded file object.
   */
  async uploadPhoto(title: string, file) {
    var data = new FormData();
    data.append("title", title);

    fetch(file.uri).then((res) =>
      res.blob().then((blob) => {
        data.append("image", blob, title);
        axios
          .post(`${this.server}/photos`, data)
          .then((res) => {
            // TODO alert the user of successful upload.
            return res.data;
          })
          // TODO do something useful with the error.
          .catch((err) => console.log(err));
      })
    );
  }

  /**
   * Makes a POST request to the webserver with a room object.
   * @param payload JSON-formatted room object.
   */
  async postRoom(payload) {
    axios
      .post(`${this.server}/rooms`, payload)
      .then((res) => {
        // TODO something useful with a successful response.
      })
      .catch((err) => {
        // TODO something useful with any error.
        console.log(err);
      });
  }
}

export const api = new API(server, axios);
