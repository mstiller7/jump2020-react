import React from "react";
import { useOvermind } from "../../overmind/config";
import { Button } from "react-native";
import { Input } from "react-native-elements";
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
          <Button title="Select Photo" onPress={() => actions.pickPhoto()} />
          <Button
            title="Submit"
            onPress={() => actions.createRoom("sample", state.photo)}
          />
        </Form>
      </Content>
    </Container>
  );
}
