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
        return response.data;
      })
      .catch((err) => console.log(err));
    return rooms;
  }

  /**
   * Utilizes a document picker dialog to choose a file for upload.
   */
  async pickImage() {
    try {
      const image = await DocumentPicker.getDocumentAsync({
        type: "image/*",
      });
      return image;
    } catch (err) {
      throw err;
    }
  }

  /**
   * Makes a POST request to the webserver containing the file.
   * @param image File to be sent.
   * @return {Promise<String>} The MongoDB ID String of the uploaded file object.
   */
  async uploadImage(image): Promise<string> {
    var data = new FormData();
    data.append("title", image.name);

    var result = "";

    await fetch(image.uri).then((res) =>
      res.blob().then((blob) => {
        data.append("image", blob, image.name);
      })
    );
    await axios
      .post(`${this.server}/images`, data)
      .then((response) => {
        // TODO alert the user of successful upload.
        result = response.data;
      })
      // TODO do something useful with the error.
      .catch((err) => console.log(err));
    return result;
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
