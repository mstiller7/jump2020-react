import React from "react";
import { useOvermind } from "../overmind/config";
import { Container, Content } from "native-base";
import { Card } from "react-native-elements";
import { Image } from "react-native";

export default function Room() {
  const { state, actions } = useOvermind();
  // TODO neaten up etc.
  
  const room = state.room;

  return (
    <Container>
      <Content>
        <Card title={room.title}>
          <Image source={actions.getImage(room.image)} />
        </Card>
      </Content>
    </Container>
  );
}
