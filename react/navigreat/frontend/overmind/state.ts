// defines the State. like a class?
type State = {
  user: string;
  rooms: Array<any>;
  payload: Array<any>;
  file: any;
};

// exports the State's initial values.
export const state: State = {
  user: "Guest",
  rooms: [],
  payload: [],
  file: null,
};
