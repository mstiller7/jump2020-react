import React from "react";
import { useOvermind } from "../overmind/config";
import { Container, Content, CardItem, Form, Text, Item } from "native-base";
import { Card, Input } from "react-native-elements";
import { Button } from "react-native";

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

  const payload = {};

  function Edit(props) {}

  const handlePATCH = async () => {
    alert(
      "Your room update has been sent to the server.\n\
      This button will PATCH the existing room.\n\
      Refreshing the page..."
    );
    // TODO something with the updated payload
  };

  return (
    <Container>
      <Content>
        <Card title={room.title}>
          <CardItem cardBody>
            <Text></Text>
            <Text style={styles.summary}>
              This is where the summary of a room would appear.
              <br />
              If it had one...
            </Text>
          </CardItem>
          <CardItem>
            <Image
              style={{ height: 500, width: null, flex: 1 }}
              source={{ uri: `data:image/;base64,${room.image}` }}
            />
          </CardItem>
          <CardItem cardBody>
            <Text style={styles.supplement}>The image should be ^ here.</Text>
          </CardItem>
        </Card>
        {/* TODO conditional rendering for edit mode */}
        <Form>
          <Item>
            <Input
              placeholder="Title"
              value={room.title}
              onChangeText={(text) => (payload.title = text)}
            />
          </Item>
          <Item>
            <Input
              placeholder="Summary"
              value={room.summary}
              onChangeText={(text) => (payload.summary = text)}
            />
          </Item>
          <Item>
            <Input
              placeholder="Building"
              value={room.building}
              onChangeText={(text) => (payload.building = text)}
            />
          </Item>
          <Item>
            <Input
              placeholder="Floor"
              value={room.floor}
              onChangeText={(text) => (payload.floor = text)}
            />
          </Item>
          <Item>
            <Input
              placeholder="Number"
              value={room.number}
              onChangeText={(text) => (payload.number = text)}
            />
          </Item>
          <Item>
            <Input
              placeholder="Capacity"
              value={room.capacity}
              onChangeText={(text) => (payload.capacity = text)}
            />
          </Item>
          <Button title="Confirm Update" onPress={handlePATCH} />
        </Form>
      </Content>
    </Container>
  );
}
