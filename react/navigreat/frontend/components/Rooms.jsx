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

export default function Rooms() {
  const { state, actions } = useOvermind();

  // a Hook to replace `componentDidMount()`.
  // TODO add caching so a refresh doesn't necessarily need to occur.
  useEffect(() => {
    actions
      .refreshRooms()
      // .then(() => {
      //   for (var i in state.rooms) {
      //     var room = state.rooms[i];
      //     actions.getImage(room.image).then((data) => {
      //       room.image = data.data;
      //     });
      //     state.rooms[i] = room;
      //   }
      // })
      // .catch((error) => console.log(error));

    // const getImages = async () => {

    // };
    // getImages();
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

  const handleNavigate = async (id) => {
    // TODO
  };

  return (
    <Container>
      {/* <Header /> */}
      <Content>
        {state.rooms.map((room, i) => {
          return (
            <Card key={i}>
              <CardItem>
                <Left>
                  <Thumbnail source="https://i.imgur.com/PYVEDqI.jpg" />
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
                  source="https://i.imgur.com/PYVEDqI.jpg"
                  // source={{ uri: `data:image/;base64,${room.image}` }}
                  style={{ height: 200, width: null, flex: 1 }}
                />
              </CardItem>
              <CardItem>
                <Button title="View" onPress={() => handleNavigate(room.id)} />
              </CardItem>
            </Card>
          );
        })}
      </Content>
    </Container>
  );
}
