// set default values in each specific reducer
const userReducer = (state = {}, action) => {
  switch (action.type) {
    case "CHANGE_NAME": {
      state = { ...state, name: action.payload };
      break;
    }
    case "CHANGE_AGE": {
      state = { ...state, age: action.payload };
      break;
    }
    default:
      return state;
  }
  return state;
};

export default userReducer;
