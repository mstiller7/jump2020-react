// import { registerRootComponent } from "expo";
import { createOvermind } from "overmind";
import { Provider } from "overmind-react";
import { config } from "./frontend/overmind/config";
import * as React from "react";
import { render } from "react-dom";

const overmind = createOvermind(
  config,
  { devtools: "localhost:2077" }
);

import App from "./frontend/App";

render(
  <Provider value={overmind}>
    <App />
  </Provider>,
  document.getElementById("root")
);

// registerRootComponent calls AppRegistry.registerComponent('main', () => App);
// It also ensures that whether you load the app in the Expo client or in a native build,
// the environment is set up appropriately
// registerRootComponent(App);
