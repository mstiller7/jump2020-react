// defines the State. like a class?
type State = {
  user: string;
  rooms: Array<any>;
};

// exports the State's initial values.
export const state: State = {
  user: "Guest",
  rooms: [],
};