import { ADD_NOTE } from "../actions/actions";

const initialState = {
  notes: [],
};

function rootReducer(state = initialState, action) {
  switch (action.type) {
    case ADD_NOTE:
      return {
        // ...states, // includes possible other properties.
        notes: [
          ...state.notes,
          {
            title: action.title,
            content: action.content,
          },
        ],
      };

    default:
      return state;
  }
}

export default rootReducer;
