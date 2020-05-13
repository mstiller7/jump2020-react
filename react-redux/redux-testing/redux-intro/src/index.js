import React from "react";
import { render } from "react-dom";
import Counter from "./components/Counter";
import { Provider } from "react-redux";
import { createStore } from "redux";

// ? make an initial state with all expected variables.
const initialState = {
  count: 0,
};

// ? make a catch-all reducer function, and create action flows
// ? based on the intended operations.
function reducer(state = initialState, action) {
  console.log(action);
  switch (action.type) {
    case "INCREMENT":
      return {
        count: state.count + 1,
      };
    case "DECREMENT":
      return {
        count: state.count - 1,
      };
    default:
      return state;
  }
}

// ? make a data store and attach the reducer to it.
const store = createStore(reducer);

// ? wrap the app in a provider component which maintains the store.
const App = () => (
  <Provider store={store}>
    <Counter />
  </Provider>
);

render(<App />, document.getElementById("root"));
