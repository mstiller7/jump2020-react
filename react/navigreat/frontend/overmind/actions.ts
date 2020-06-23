// export { default as http } from "axios";
import axios from "axios";

// TODO remove later on when not in dev
const server = "http://localhost:8080/api";

/**
 * Makes a GET request to obtain the current list of rooms.
 */
export const refreshRooms = async ({ state, actions }) => {
  state.rooms = await axios.get(`${server}/rooms`).then((response) => {
    return response.data;
  });

  var rooms = state.rooms.map((r) => ({ ...r }));
  for (const room of rooms) {
    await actions.getImage(room.image).then((response) => {
      room.image = response.data;
    });
  }
  state.rooms = rooms;
};

/**
 * Makes a POST request to the webserver with a room object.
 * @param payload JSON-formatted room object.
 */
export const postRoom = async ({ state, actions }, payload) => {
  console.log("Payload: ", payload);
  await axios
    .post(`${server}/rooms`, payload)
    .then((res) => {
      // TODO something useful with a successful response.
      actions.refreshRooms();
    })
    .catch((err) => {
      // TODO something useful with any error.
      console.log(err);
    });
};

export const postImage = async ({}, payload) => {
  var result = await axios
    .post(`${server}/images`, payload)
    .then((response) => {
      // TODO alert the user of successful upload.
      return response;
    })
    // TODO do something useful with the error.
    .catch((err) => console.log(err));
  return result;
};

// even though the state isn't used here, the first param is Overmind.
export const getImage = async ({}, id: String) => {
  var img = {
    title: "",
    data: "",
  };

  await axios.get(`${server}/images/${id}`).then((response) => {
    img.title = response.data.title;
    img.data = response.data.image.data;
  });
  // console.log(img);
  // .catch((error) => console.log(error));

  return img;
};
