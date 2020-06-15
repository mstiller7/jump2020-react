// overmind/actions.ts
import { Action } from "overmind";
import { createEffectsHook } from "overmind-react";

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

export const postRoom = async ({ state, actions, effects }, payload) => {
  await effects.api.postRoom(payload).then((result) => {
    actions.refreshRooms();
  })
};

export const removeRoom: Action<any> = ({ state }, room) => {};
