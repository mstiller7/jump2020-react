/**
 * Requests the room data from the webserver.
 */
export const refreshRooms = async ({ state, effects }) => {
  await effects.api.updateRooms().then((result) => {
    state.rooms = result;
  });
};

export const pickImage = async ({ state, effects }) => {
  state.file = await effects.api.pickImage();
  return state.file;
};

export const uploadImage = async ({ state, effects }) => {
  state.file = await effects.api.uploadImage(state.file);
  return state.file;
};

export const postRoom = async ({ actions, effects }, payload) => {
  await effects.api.postRoom(payload).then((result) => {
    actions.refreshRooms();
  });
};
