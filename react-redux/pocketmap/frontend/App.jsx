// React/Native
import React from "react";

// ? Setup Overmind
import { createOvermind } from "overmind";
import { createHook, Provider } from "overmind-react";
import config from "./overmind/config";

const overmind = createOvermind(config);
export const useOvermind = createHook();

// ? Construct UI
import UI from "./UI";

const App = () => {
  return (
    <Provider value={overmind}>
      <UI />
    </Provider>
  );
};

export default App;
