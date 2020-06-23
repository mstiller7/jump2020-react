import { useOvermind } from "../overmind/config";
import React from "react";
import { Button } from "react-native";
import { Input } from "react-native-elements";
import { Container, Content, Form, Item } from "native-base";
import * as DocumentPicker from "expo-document-picker";

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

  /**
   *
   */
  const handleSelect = async () => {
    payload.image = await DocumentPicker.getDocumentAsync({
      type: "image/*",
    });
  };

  /**
   * Makes a POST request to the webserver containing the file.
   * @return {Promise<String>} The MongoDB ID String of the uploaded file object.
   */
  const handleUpload = async () => {
    var img = payload.image;
    var data = new FormData();
    data.append("title", img.name);

    var blob = await fetch(img.uri).then((res) => {
      return res.blob();
    });
    data.append("image", blob, img.name);

    payload.image = await actions.postImage(data).then((response) => {
      return response.data;
    });
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
          <Button title="Submit" onPress={() => actions.postRoom(payload)} />
        </Form>
      </Content>
    </Container>
  );
}
