import React from "react";
import { useOvermind } from "../overmind/config";
import { Container, Content, CardItem, Form, Text, Item } from "native-base";
import { Card, Input } from "react-native-elements";
import { Button } from "react-native";

import { Image } from "react-native";
import { useEffect } from "react";

export default function Room({ route }) {
  const { state, actions } = useOvermind();
  // TODO neaten up etc.

  const { id } = route.params;
  const room = state.rooms[id];

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

  // ? We again begin with the payload structure.
  const payload = {
    id: room.id,
    title: room.title,
    summary: "",
    building: room.building,
    floor: room.floor,
    number: room.number,
    capacity: room.capacity,
    image: room.image,
  };
  
  useEffect(() => {}, [state.edit]);

  const handlePATCH = async () => {
    actions.postRoom(payload);
    actions.refreshRooms();
    // TODO why doesn't the image re-appear?
    // TODO on subsequent refreshes, the summary isn't saved
    // actions.assignImages();
    actions.toggleEdit();
    // TODO replace image base64 payload with the ID ref again
    // TODO confirmation alert upon success
  };

  if (state.edit === false)
    return (
      <Container>
        <Content>
          <Button title="Edit..." onPress={actions.toggleEdit} />
          <Card title={room.title}>
            <CardItem cardBody>
              <Text></Text>
              <Text style={styles.summary}>
                {room.summary}
                <br />
                This is where the summary of a room would appear.
                <br />
                If it had one...
              </Text>
            </CardItem>
            <CardItem>
              <Image
                style={{ height: 500, width: null, flex: 1 }}
                source={{ uri: `data:image/;base64,${room.base64}` }}
              />
            </CardItem>
            <CardItem cardBody>
              <Text style={styles.supplement}>The image should be ^ here.</Text>
            </CardItem>
          </Card>
        </Content>
      </Container>
    );
  else
    return (
      <Container>
        <Content>
          <Form>
            <Item>
              <Input
                placeholder="Title"
                defaultValue={room.title}
                onChangeText={(text) => (payload.title = text)}
              />
            </Item>
            <Item>
              <Input
                placeholder="Summary"
                defaultValue={room.summary}
                onChangeText={(text) => (payload.summary = text)}
              />
            </Item>
            <Item>
              <Input
                placeholder="Building"
                defaultValue={room.building}
                onChangeText={(text) => (payload.building = text)}
              />
            </Item>
            <Item>
              <Input
                placeholder="Floor"
                defaultValue={room.floor}
                onChangeText={(text) => (payload.floor = text)}
              />
            </Item>
            <Item>
              <Input
                placeholder="Number"
                defaultValue={room.number}
                onChangeText={(text) => (payload.number = text)}
              />
            </Item>
            <Item>
              <Input
                placeholder="Capacity"
                defaultValue={room.capacity}
                onChangeText={(text) => (payload.capacity = text)}
              />
            </Item>
            <Button title="Confirm Update" onPress={handlePATCH} />
          </Form>
        </Content>
      </Container>
    );
}
