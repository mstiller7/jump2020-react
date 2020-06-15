/**
 * Requests the room data from the webserver.
 */
export const refreshRooms = async ({ state, effects }) => {
  await effects.api.updateRooms().then((result) => {
    state.rooms = result;
  });
};

export const pickImage = async ({ state, effects }) => {
  await effects.api.pickImage().then((response) => {
    return response;
  });
};

export const uploadImage = async ({ effects }, image) => {
  await effects.api.uploadImage(image).then((response) => {
    return response;
  });
};

export const postRoom = async ({ state, actions, effects }, payload) => {
  console.log("Room payload: ", payload);
  await effects.api.postRoom(payload).then((result) => {
    actions.refreshRooms();
  });
};
