import React from 'react';
import { BrowserRouter as Router, Route } from "react-router-dom";

import Store from "./Store";
import Landing from "./Landing"

function App() {
  return (
    <Store>
      <Router>
        <Route exact path="/" component={Landing} />
      </Router>
    </Store>
  );
}

export default App;
