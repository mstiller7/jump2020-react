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
import { Button, SearchBar } from "react-native-elements";

export default function Rooms({ navigation }) {
  const { state, actions } = useOvermind();

  const { search } = state;

  // var filtered = [];

  // a Hook to replace `componentDidMount()`.
  // TODO add caching so a refresh doesn't necessarily need to occur.
  useEffect(() => {
    actions.refreshRooms().then(() => {
      actions.assignImages();
      // filtered = state.rooms.find((room) => room.title.includes(state.search));
      // console.log("Filtered rooms:", filtered);
    });
  }, []);
  // ? the empty array here ensures the component
  // ? doesn't continually re-render.
  // TODO add a refresh button?

  // const screen = {
  //   search: "",
  // };

  const styles = {
    title: {
      // "font-size": "xx-large",
      "font-weight": "bold",
    },
  };

  const handleNavigate = (id) => {
    navigation.navigate("Room", { id: id });
  };

  const handleSearch = (value) => {
    // TODO search bar for rooms display
    actions.updateSearch(value);
    // console.log("Value:", value);
    // console.log("Screen.search:", screen.search);
  };

  const uiSearch = React.useRef(null);

  return (
    <Container>
      <Content>
        <SearchBar
          ref={uiSearch}
          placeholder="Search..."
          onChangeText={(value) => handleSearch(value)}
          value={search}
        />
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
