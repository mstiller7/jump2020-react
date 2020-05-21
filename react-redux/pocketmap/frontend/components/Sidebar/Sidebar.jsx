import React from "./node_modules/react";
import { View, Text } from "react-native";
// Styles
import "./Sidebar.less";

export default function Sidebar() {
  return (
    <View style={{ padding: "10px" }}>
      <Text>This is the sidebar.</Text>
    </View>
  );
}
