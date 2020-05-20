import Axios from "axios";

export function updateRooms() {
  Axios.get("http://localhost:8080/rooms")
    .then((response) => {
      // takes the given data path from the server API response
      const data = response.data._embedded.rooms;

      const rooms = data.map((r) => {
        return {
          name: r.name,
        };
      });

      console.log(rooms);

      // dispatch the customers to the store
      return rooms;
    })
    .catch((error) => console.log(error));
}
