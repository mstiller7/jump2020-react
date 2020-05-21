import React from "react";
import { View, Text } from "react-native";
// Styles
import "./Map.less";
import { useOvermind } from "../../overmind/config";

export default function Map() {
  const { state } = useOvermind();

  return (
    <View style={{ padding: "10px" }}>
      <ul>
        {state.rooms.map((room) => (
          <Text key={room.id}>{room.name}</Text>
        ))}
      </ul>
    </View>
  );
}
