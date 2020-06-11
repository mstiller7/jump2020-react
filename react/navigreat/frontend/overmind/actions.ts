// overmind/actions.ts
import { Action } from "overmind";

export const login: Action<string> = ({ state }, user) => {
  state.user = user;
};

export const logout: Action<string> = ({ state }) => {
  state.user = "Guest";
};

// ? Clear all rooms from the state and retrieve a fresh copy.
export const refreshRooms = async ({ state, effects }) => {
  await effects.api.updateRooms().then((result) => {
    state.rooms = result;
  });
};

export const findRoom: Action<string> = ({ state }, room) => {
  if (state.rooms.indexOf(room) >= 0) {
  }
};

export const pickPhoto = async ({ state, effects }) => {
  await effects.api.pickFile().then((result) => {
    state.photo = result;
  });
};

export const uploadPhoto = async ({ state, effects }, title) => {
  await effects.api.uploadPhoto(title, state.photo).then((result) => {
    state.photo = result;
  });
};

export const insertRoom: Action<any> = ({ state }, room) => {
  state.rooms.push(room);
};

export const removeRoom: Action<any> = ({ state }, room) => {};
