import React from "react";
import { View, Button } from "react-native";

export default function Landing({ navigation }) {
  return (
    <View style={{ padding: "10px" }}>
      <Button
        title="View Maps"
        color="#9999ff"
        onPress={() => navigation.navigate("Map")}
      />
      <Button
        title="View Rooms"
        color="#ff9933"
        onPress={() => navigation.navigate("Rooms")}
      />
      <Button
        title="Create Room"
        color="#00cc99"
        onPress={() => navigation.navigate("Create")}
      />
    </View>
  );
}
