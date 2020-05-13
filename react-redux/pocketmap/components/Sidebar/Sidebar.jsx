import React from "react";
import { Component } from "react";
import { View, Button } from "react-native";
import { TextInput } from "react-native-gesture-handler";
// Styles
import "./Sidebar.less";

export default class Sidebar extends Component {
  render() {
    return (
      <View style={{ padding: "10px" }}>
        <TextInput placeholder="Enter your name." />
        <Button
          title="View Maps"
          onPress={() => this.props.navigation.navigate("Map")}
        />
      </View>
    );
  }
}
