import Axios from "axios";

export async function updateRooms() {
  try {
    const response = await Axios.get("http://localhost:8080/rooms");
    // takes the given data path from the server API response
    const data = response.data._embedded.rooms;
    const rooms = data.map((r) => {
      return {
        name: r.name,
      };
    });
    console.log(rooms);
    return rooms;
  } catch (error) {
    return console.log(error);
  }
}
