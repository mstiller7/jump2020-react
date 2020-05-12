// 404 page

import React from "react";
import { Component } from "react";
import { View, Text } from "react-native";

export default class Invalid extends Component {
  render() {
    return (
      <View>
        <Text>404. That's all we know.</Text>
      </View>
    )
  }
}