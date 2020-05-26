import React, { useEffect } from "react";
import { View, Text } from "react-native";
import { Card, ListItem } from "react-native-elements";
// Styles
import "./Rooms.less";
import { useOvermind } from "../../overmind/config";

export default function Rooms() {
  const { state, actions } = useOvermind();

  // a Hook to replace `componentDidMount()`.
  // TODO add caching so a refresh doesn't necessarily need to occur.
  useEffect(() => {
    actions.refreshRooms();
  }, []);
  // ? the empty array here ensures the component
  // ? doesn't continually re-render.
  
  // TODO add a refresh button?
  // useEffect(() => {
  //   actions.refreshRooms();
  // }, [state.rooms.length]);

  return (
    <View style={{ padding: "10px" }}>
      <Card>
        {state.rooms.map((room, i) => {
          return <ListItem key={i} title={room.name} />;
        })}
      </Card>
    </View>
  );
}
