import { useOvermind } from "../overmind/config";
import React, { useEffect, useRef } from "react";
import { Button } from "react-native";

import { Image } from "react-native";
import { Input } from "react-native-elements";
import { Container, Content, Form, Item } from "native-base";
import * as DocumentPicker from "expo-document-picker";

export default function Rooms({ navigation }) {
  const { state, actions } = useOvermind();

  const payload = {
    title: "",
    building: "",
    floor: "",
    number: "",
    capacity: "",
    image: null,
    base64: null,
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
    handleGet();
  };

  const handleGet = async () => {
    if (payload.base64 != null) {
      console.log("Upload confirmed. Displaying preview...");
      payload.base64 = await actions
        .getImage(payload.image)
        .then((response) => {
          return response.data;
        });
      console.log(payload.base64);
    }
  };

  // TODO reset fields button

  return (
    <Container>
      <Content>
        <Form>
          <Item>
            <Input
              placeholder="Title"
              onChangeText={(text) => {
                payload.title = text;
                actions.pushPayload(payload);
              }}
            />
          </Item>
          <Item>
            <Input
              placeholder="Building"
              onChangeText={(text) => {
                payload.building = text;
                actions.pushPayload(payload);
              }}
            />
          </Item>
          <Item>
            <Input
              placeholder="Floor"
              onChangeText={(text) => {
                payload.floor = text;
                actions.pushPayload(payload);
              }}
            />
          </Item>
          <Item>
            <Input
              placeholder="Number"
              onChangeText={(text) => {
                payload.number = text;
                actions.pushPayload(payload);
              }}
            />
          </Item>
          <Item>
            <Input
              placeholder="Capacity"
              onChangeText={(text) => {
                payload.capacity = text;
                actions.pushPayload(payload);
              }}
            />
          </Item>
          <Button title="Select Image" onPress={handleSelect} />
          <Button title="Confirm Upload" onPress={handleUpload} />
          <Image
            style={{ height: 500, width: null, flex: 1 }}
            source={{ uri: `data:image/;base64,${payload.base64}` }}
          />
          {/* <Button title="Log Payload" onPress={() => console.log(payload)} /> */}
          <Button
            title="Submit"
            onPress={() => {
              delete payload[-1];
              console.log("Payload to be sent:", payload);
              actions.postRoom(payload).then(() =>
                actions.refreshRooms().then(() => {
                  actions.assignImages().then(() => {
                    navigation.navigate("Room", { id: state.rooms.length - 1 });
                  });
                })
              );
            }}
          />
        </Form>
      </Content>
    </Container>
  );
}
