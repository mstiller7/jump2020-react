import React from "react";
import { useOvermind } from "../overmind/config";
import { Container, Content } from "native-base";
import { Card } from "react-native-elements";
import { Image } from "react-native";

export default function Room(room) {
  const { actions } = useOvermind();

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
