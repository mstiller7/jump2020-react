// React/Native
import React from "react";
import "react-native-gesture-handler";
import { createStackNavigator } from "@react-navigation/stack";
import { NavigationContainer } from "@react-navigation/native";
// Components
import Landing from "./components/Landing";
import Map from "./components/Map";
import Rooms from "./components/Rooms";
import Create from "./components/Create";

// ? Setup Overmind
import { useOvermind } from "./overmind/config";

// ? Construct UI
const Stack = createStackNavigator();

export default function App() {
  const { state, actions, effects, reaction } = useOvermind();

  return (
    <NavigationContainer>
      <Stack.Navigator initialRouteName="Landing">
        <Stack.Screen name="Landing" component={Landing} />
        <Stack.Screen name="Map" component={Map} />
        <Stack.Screen name="Rooms" component={Rooms} />
        <Stack.Screen name="Create" component={Create} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}

// export default App;
