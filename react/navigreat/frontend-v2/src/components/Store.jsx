import React from "react";

const initialState = {};

// ! Defines the possible actions that can be taken to update the global state.
// ! Add new cases to introduce new functionality.
const Reducer = (state, action) => {
  switch (action.type) {
    default:
      return state;
  }
};

const Store = ({ children }) => {
  const [state, dispatch] = React.useReducer(Reducer, initialState);
  return (
    <AppContext.Provider value={[state, dispatch]}>
      {children}
    </AppContext.Provider>
  );
};

// ? Exports the global context for components to import and use.
export const AppContext = React.createContext(initialState);
export default Store;