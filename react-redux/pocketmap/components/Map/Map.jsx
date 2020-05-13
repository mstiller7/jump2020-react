import React from "react";
import { Component } from "react";
import { View } from "react-native";
import { TextInput } from "react-native-gesture-handler";
// Styles
import "./Map.less";

export default class Map extends Component {
  render() {
    return (
      <View style={{padding: "10px"}}>
        <TextInput placeholder="Enter the map to view." />
      </View>
    );
  }
}
