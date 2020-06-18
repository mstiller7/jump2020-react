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

  const handleSelect = async () => {
    try {
      const image = await DocumentPicker.getDocumentAsync({
        type: "image/*",
      });
      // payload.image = image;
      payload.image = await handleUpload(image);
    } catch (err) {
      throw err;
    }
  };

  /**
   * Makes a POST request to the webserver containing the file.
   * @param image File to be sent.
   * @return {Promise<String>} The MongoDB ID String of the uploaded file object.
   */
  const handleUpload = async (image) => {
    var data = new FormData();
    data.append("title", image.name);

    var result = "";

    await fetch(image.uri).then((res) =>
      res
        .blob()
        .then((blob) => {
          data.append("image", blob, image.name);
          return data;
        })
        .then((payload) => {
          console.log(payload);
          actions.post("images", payload).then((response) => {
            result = response.data;
          });
          return result;
        })
    );
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
          <Button title="Confirm Upload" disabled onPress={handleUpload} />
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
