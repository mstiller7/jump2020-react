// overmind/actions.ts
import { Action } from "overmind";

export const login: Action<string> = ({ state }, user) => {
  state.user = user;
};

export const logout: Action<string> = ({ state }) => {
  state.user = "Guest";
};
