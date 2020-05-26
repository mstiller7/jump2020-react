import React from "react";
import { Component } from "react";
import { View, Text, TextInput, StyleSheet } from "react-native";
// Styles
import "./Landing.less";

export default class Landing extends Component {
  render() {
    return (
      <View style={{padding: 10}}>
        <TextInput placeholder="Your words go here." />
        {/* <Greeting name="Matthew" /> */}
        {/* <Greeting name="Jillian" /> */}
        {/* <Greeting name="Gabby" /> */}
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
