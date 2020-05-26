export { default as http } from "axios";
import axios from "axios";

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
    const rooms = this.request
      .get(`${this.server}/rooms`)
      .then((response) => {
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
  }
}

export const api = new API(server, axios);
