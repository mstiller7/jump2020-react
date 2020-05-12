import React from "react";
import ReactDOM from "react-dom";
import "./styles/index.css";
// import App from "./components/App";
import * as serviceWorker from "./services/serviceWorker";
import Landing from "./components/Landing";

import { Provider } from "react-redux";
import { createStore, combineReducers } from "redux";

import tweetsReducer from "./model/reducers/TweetsReducer";
import userReducer from "./model/reducers/UserReducer";

// combine all reducers.
const reducers = combineReducers({
  user: userReducer,
  tweet: tweetsReducer,
});

const store = createStore(reducers);

store.subscribe(() => {
  console.log("Store changed:", store.getState());
  // TODO maybe more here based on any events
});

store.dispatch({ type: "CHANGE_NAME", payload: "Will" });
store.dispatch({ type: "CHANGE_AGE", payload: 35 });

// Wrap the app in a provider component which maintains the store.
const App = () => {
  return (
    <Provider store={store}>
      <Landing />
    </Provider>
  );
};

// =================================================================
// React's default rendering method.
// Shouldn't need to touch; add components to App() above.

ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById("root")
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.register();
