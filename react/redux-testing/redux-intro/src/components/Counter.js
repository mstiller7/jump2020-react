import React from "react";
import { connect } from "react-redux";

// ? 2) returns the app's state as a set of props,
// ? mapping any desired state properties to a local var
function mapStateToProps(state) {
  return {
    count: state.count,
  };
}

// ? 3) using dispatches to handle redux actions without managing state.
class Counter extends React.Component {
  increment = () => {
    this.props.dispatch({ type: "INCREMENT" });
  };

  decrement = () => {
    this.props.dispatch({ type: "DECREMENT" });
  };

  render() {
    return (
      <div>
        <h2>Counter</h2>
        <div>
          <button onClick={this.decrement}>-</button>
          <span>{this.props.count}</span>
          <button onClick={this.increment}>+</button>
        </div>
      </div>
    );
  }
}

// ? 1) connects the  component to the app's data store.
// ? needs to come after Counter has been defined.
export default connect(mapStateToProps)(Counter);

// Add this function:

// Then replace this:
// export default Counter;

// With this:

// What connect does is hook into Redux, pull out the entire state,
// and pass it through the mapStateToProps function that you provide.
// This needs to be a custom function because only you will know
// the “shape” of the state in Redux.
