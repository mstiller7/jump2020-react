import React from "react";
import { Component } from "react";
import { View, Text, StyleSheet } from "react-native";
import "./Landing.less";

export default class Landing extends Component {
  render() {
    return (
      <View style={styles.center}>
        <Greeting name="Matthew" />
        <Greeting name="Jillian" />
        <Greeting name="Gabby" />
      </View>
    );
  }
}

function Greeting(props) {
  return (
    <View styles={styles.center}>
      <Text>Hello {props.name}!</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  center: {
    alignItems: "center",
  },
});
