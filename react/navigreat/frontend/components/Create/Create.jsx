import { useOvermind } from "../../overmind/config";
import React from "react";
import { Button } from "react-native";
import { Input } from "react-native-elements";
import { Container, Content, Form, Item } from "native-base";

export default function Rooms() {
  const { state, actions } = useOvermind();

  const payload = {
    title: "",
    photo: "",
    building: "",
    floor: "",
    number: "",
    capacity: "",
  };

  return (
    <Container>
      <Content>
        <Form>
          <Item>
            <Input
              placeholder="Title"
              onChangeText={(text) => (payload.title = text)}
            />
          </Item>
          <Item>{/* TODO photo selection */}</Item>
          <Item>
            <Input
              placeholder="Building"
              onChangeText={(text) => (payload.building = text)}
            />
          </Item>
          <Item>
            <Input
              placeholder="Floor"
              onChangeText={(text) => (payload.floor = text)}
            />
          </Item>
          <Item>
            <Input
              placeholder="Number"
              onChangeText={(text) => (payload.number = text)}
            />
          </Item>
          <Item>
            <Input
              placeholder="Capacity"
              onChangeText={(text) => (payload.capacity = text)}
            />
          </Item>
          <Button title="Submit" onPress={() => actions.postRoom(payload)} />
        </Form>
      </Content>
    </Container>
  );
}
