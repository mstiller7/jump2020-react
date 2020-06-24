import React from "react";
import { useOvermind } from "../overmind/config";
import { Container, Content, CardItem, Text } from "native-base";
import { Card } from "react-native-elements";
import { Image } from "react-native";

export default function Room({ route }) {
  const { state } = useOvermind();
  // TODO neaten up etc.

  const { id } = route.params;
  const room = state.rooms[id];
  console.log(room);

  const styles = {
    summary: {
      color: "blue",
      fontSize: 32,
      fontFamily: "Arial, Helvetica, sans-serif",
    },
    supplement: {
      color: "purple",
      fontSize: 17,
    },
  };

  return (
    <Container>
      <Content>
        <Card title={room.title}>
          <CardItem cardBody>
            <Text style={styles.summary}>
              This is where the summary of a room would appear.
              <br />
              If it had one...
            </Text>
          </CardItem>
          <CardItem>
            {/* TODO figure out why Image not binding. */}
            <Image source={{ uri: `data:image/;base64,${room.image}` }} />
          </CardItem>
          <CardItem cardBody>
            <Text style={styles.supplement}>The image should be ^ here.</Text>
          </CardItem>
        </Card>
      </Content>
    </Container>
  );
}
