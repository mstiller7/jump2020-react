import React from "react";
import { connect } from "react-redux";
import { Component } from "react";
import { View, Button } from "react-native";
// Styles
import "./Landing.less";

export default class Landing extends Component {
  render() {
    return (
      <View style={{ padding: "10px" }}>
        <Button
          title="View Maps"
          onPress={() => this.props.navigation.navigate("Map")}
        />
      </View>
    );
  }
}
