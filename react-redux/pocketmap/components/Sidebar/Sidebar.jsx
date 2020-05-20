import React from "react";
import { Component } from "react";
import { View, Text } from "react-native";
// Styles
import "./Sidebar.less";

export default class Sidebar extends Component {
  render() {
    return (
      <View style={{ padding: "10px" }}>
        <Text>This is the sidebar.</Text>
      </View>
    );
  }
}
