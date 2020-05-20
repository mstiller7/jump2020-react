// set default values in each specific reducer
const userReducer = (state = {}, action) => {
  switch (action.type) {
    case "CHANGE_USER": {
      state = { ...state, user: action.payload };
      break;
    }
    default:
      return state;
  }
  return state;
};

export default userReducer;
