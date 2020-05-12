// * =================================================================
// * Imports
// * =================================================================

// React
import React from "react";
import ReactDOM from "react-dom";
import { Switch, BrowserRouter as Router, Route } from "react-router-dom";
// Redux
import { createStore, combineReducers } from "redux";
import { Provider } from "react-redux";
// Components
import Landing from "./components/Landing/Landing";
import Invalid from "./components/Invalid/Invalid";
// Functions
import tweetsReducer from "./model/reducers/TweetsReducer";
import userReducer from "./model/reducers/UserReducer";

// * =================================================================
// * Functional setup
// * =================================================================

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
      <Router>
        <Switch>
          <Route exact path="/" component={Landing} />
          <Route component={Invalid} />
        </Switch>
      </Router>
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
