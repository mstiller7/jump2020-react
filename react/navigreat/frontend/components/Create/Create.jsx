import React from "react";
import { useOvermind } from "../../overmind/config";
import { Input, Button, Text } from "react-native-elements";
import { Container, Content, Form, Item } from "native-base";

export default function Create() {
  const { state, actions } = useOvermind();

  return (
    <Container>
      <Content>
        <Form>
          <Item>
            <Input placeholder="Title" />
          </Item>
          <Button onPress={() => actions.pickPhoto()}>
            <Text>Select Photo</Text>
          </Button>
          <Button onPress={() => actions.createRoom(state.title, state.photo)}>
            <Text>Select Photo</Text>
          </Button>
        </Form>
      </Content>
    </Container>
  );
}
