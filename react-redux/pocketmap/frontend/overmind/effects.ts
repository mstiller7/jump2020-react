export { default as http } from "axios";
import axios from "axios";

const server = "http://localhost:8080";

export const api = (() => {
  let app: any;

  return {
    initialize() {
      // TODO any initialization for the 'app' state.
    },
    // ? Maps the rooms data to an array of values.
    updateRooms() {
      const rooms = axios
        .get(server + "/rooms")
        .then((response) => {
          const rooms = response.data._embedded.rooms.map(
            (r: { name: any }) => {
              return {
                name: r.name,
                // TODO more rooms data as desired.
              };
            }
          );
          return rooms;
        })
        .catch(this.handleError);
      console.log(rooms);
      return rooms;
    },
  };
})();
