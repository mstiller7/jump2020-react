import React from "react";
import { Component } from "react";
import { View, Button } from "react-native";
import { connect } from "react-redux";
// Styles
import "./Map.less";
// Functions
import { updateRooms } from "../functions/Rooms";

// =================================================================

// maps the Provider's store state to this component's props
// may include 'ownProps' arg if necessary, not required
function receives(state) {
  return { rooms: state.rooms };
  // component will receive: props.rooms
}

// exported dispatching actions to the Provider
const dispatches = {
  updateRooms,
};

// =================================================================

class Map extends Component {
  // called when the component is loaded into the DOM
  componentDidMount() {
    updateRooms;
  }

  render() {
    return (
      <View style={{ padding: "10px" }}>
        <Button title="Refresh" onPress={updateRooms} />
      </View>
    );
  }
}

// =================================================================

// finally, exports the component with a provider connection.
export default connect(receives, dispatches)(Map);
