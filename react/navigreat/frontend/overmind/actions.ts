import axios from "axios";
import { state } from "./state";

// TODO remove later on when not in dev
const server = "http://localhost:8080/api";

export const pushPayload = ({ state }, payload) => {
  state.payload = payload;
};

/**
 * Makes a GET request to obtain the current list of rooms.
 */
export const refreshRooms = async ({ state }) => {
  state.rooms = await axios.get(`${server}/rooms`).then((response) => {
    return response.data;
  });
};

/**
 * Requests a specific room from the webserver.
 * @param {String} id The room ID to request.
 */
export const getRoom = async ({ state }, id: String) => {
  state.room = await axios.get(`${server}/rooms/${id}`).then((response) => {
    return response.data;
  });
};

/**
 * Iterates through the rooms in the state,
 * assigning the retrieved images to each.
 */
export const assignImages = async ({ state, actions }) => {
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
export const postRoom = async ({ actions }, payload) => {
  await axios.post(`${server}/rooms`, payload).then(() => {
    // TODO something useful with a successful response.
    actions.refreshRooms();
  });
};

/**
 * Makes a POST request to the Spring Boot backend.
 * @param {FormData} payload The image file to be POSTed.
 */
export const postImage = async ({}, payload: FormData) => {
  var result = await axios
    .post(`${server}/images`, payload)
    .then((response) => {
      // TODO alert the user of successful upload.
      return response;
    });
  return result;
};

/**
 * Retrieves an image from the Spring Boot backend application.
 * @param id The String ID of an image to retrieve.
 */
export const getImage = async ({}, id: String) => {
  var img = {
    title: "",
    data: "",
  };

  await axios
    .get(`${server}/images/${id}`)
    .then((response) => {
      img.title = response.data.title;
      img.data = response.data.image.data;
    })
    .catch((error) => {
      console.log(error);
    });

  return img;
};

export const updateSearch = ({ state }, value) => {
  state.search = value;

  var filtered = state.rooms.find((room) => room.title.includes(state.search));
  console.log("Filtered rooms:", filtered);

  return state.search;
};
