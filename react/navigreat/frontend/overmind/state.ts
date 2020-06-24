// defines the State. like a class?
type State = {
  user: string;
  rooms: Array<Room>;
  file: any;
};

type Room = {
  title: String;
  imageRef: String;
  imageData: String;
  building: number;
  floor: number;
  capacity: number;
  reservations: Array<any>;
};

// exports the State's initial values.
export const state: State = {
  user: "Guest",
  rooms: [],
  file: null,
};
