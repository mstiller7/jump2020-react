export { default as http } from "axios";
import axios from "axios";

// TODO remove later on when not in dev
const server = "http://localhost:8080/api";

/**
 * Makes a GET request to obtain the current list of rooms.
 */
export const refreshRooms = async ({ state }) => {
  await axios.get(`${server}/rooms`).then((response) => {
    state.rooms = response.data;
  });
};

/**
 * Makes a POST request to the webserver with a room object.
 * @param payload JSON-formatted room object.
 */
export const postRoom = async ({ state, actions }, payload) => {
  axios
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

export const post = async (path, payload) => {
  var result;
  console.log(path, payload);
  await axios
    .post(`${server}/${path}`, payload)
    .then((response) => {
      // TODO alert the user of successful upload.
      console.log(response);
      result = response;
    })
    // TODO do something useful with the error.
    .catch((err) => console.log(err));
  return result;
};

// export const getImage = async (id) => {
//   var img = {
//     title: "",
//     data: "",
//   };

//   await axios
//     .get(`${this.server}/images/${id}`)
//     .then((response) => {
//       img.title = response.data.title;
//       img.data = response.data.image.data;
//     })
//     .catch((error) => console.log(error));

//   return img;
// };
