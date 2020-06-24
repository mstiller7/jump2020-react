import React, { useEffect } from "react";
import { Image } from "react-native";
import {
  Container,
  Card,
  Content,
  CardItem,
  Left,
  Body,
  Text,
  Thumbnail,
} from "native-base";
import { useOvermind } from "../overmind/config";
import { Button } from "react-native-elements";

export default function Rooms({ navigation }) {
  const { state, actions } = useOvermind();

  // a Hook to replace `componentDidMount()`.
  // TODO add caching so a refresh doesn't necessarily need to occur.
  useEffect(() => {
    actions.refreshRooms().then(() => actions.assignImages());
  }, []);
  // ? the empty array here ensures the component
  // ? doesn't continually re-render.
  // TODO add a refresh button?

  const styles = {
    title: {
      // "font-size": "xx-large",
      "font-weight": "bold",
    },
  };

  const handleNavigate = (id) => {
    // actions.setRoom(id);
    navigation.navigate("Room", { id: id });
  };

  return (
    <Container>
      <Content>
        {state.rooms.map((room, i) => {
          return (
            <Card key={i}>
              <CardItem>
                <Left>
                  <Thumbnail
                    source={{ uri: `data:image/;base64,${room.image}` }}
                  />
                  <Body>
                    <Text style={styles.title}>{room.title}</Text>
                    <Text note>
                      Location: Building {room.building} #{room.number}
                    </Text>
                  </Body>
                </Left>
              </CardItem>
              <CardItem cardBody>
                <Image
                  source={{ uri: `data:image/;base64,${room.image}` }}
                  style={{ height: 200, width: null, flex: 1 }}
                />
              </CardItem>
              <CardItem>
                <Button title="View" onPress={() => handleNavigate(i)} />
              </CardItem>
            </Card>
          );
        })}
      </Content>
    </Container>
  );
}
