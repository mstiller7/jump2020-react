// overmind/actions.ts
import { Action } from "overmind";

export const login: Action<string> = ({ state }, user) => {
  state.user = user;
};

export const logout: Action<string> = ({ state }) => {
  state.user = "Guest";
};

// ? Clear all rooms from the state and retrieve a fresh copy.
export const refreshRooms: Action<any> = async ({ state, effects }) => {
  state.rooms = await effects.api.updateRooms();
};

export const findRoom: Action<string> = ({ state }, room) => {
  if (state.rooms.indexOf(room) >= 0) {
  }
};

export const createRoom = async ({ state, effects }, title, image) => {
  state.photo = await effects.api.createRoom(title, image);
};

export const pickPhoto = ({ state, effects }) => {
  state.photo = effects.api.pickFile();
};

export const insertRoom: Action<any> = ({ state }, room) => {
  state.rooms.push(room);
};

export const removeRoom: Action<any> = ({ state }, room) => {};
