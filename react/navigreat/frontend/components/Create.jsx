import { useOvermind } from "../overmind/config";
import React, { useEffect } from "react";
import { Button } from "react-native";
import { Input } from "react-native-elements";
import { Container, Content, Form, Item } from "native-base";

export default function Rooms() {
  const { actions } = useOvermind();

  const payload = {
    title: "",
    building: "",
    floor: "",
    number: "",
    capacity: "",
    image: null,
  };

  const handleSelect = async () => {
    payload.image = await actions.pickImage();
  };

  const handleUpload = async () => {
    console.log("Uploading...");
    payload.image = await actions.uploadImage();
    console.log("Uploaded image ID: ", payload.image);
  };

  // const enabled = payload.image.length > 10;

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
          <Button title="Select Image" onPress={handleSelect} />
          <Button title="Confirm Upload" onPress={handleUpload} />
          <Button
            title="Submit"
            // disabled={!enabled}
            onPress={() => actions.postRoom(payload)}
          />
        </Form>
      </Content>
    </Container>
  );
}
