// * =================================================================
// * Imports
// * =================================================================

// React/Native
import * as React from "react";
import { View } from "react-native";
import "react-native-gesture-handler";
import { NavigationContainer, StackActions } from "@react-navigation/native";
import { createStackNavigator } from "@react-navigation/stack";
// Redux
import { createStore, combineReducers } from "redux";
import { Provider } from "react-redux";
// Reducer functions
import userReducer from "./functions/UserReducer";
// Components
import Sidebar from "./Sidebar/Sidebar";
import Map from "./Map/Map";

// * =================================================================
// * Functional setup
// * =================================================================

// combine all reducers.
const store = createStore(
  combineReducers({
    user: userReducer,
  })
);

// * =================================================================
// * App rendering
// * =================================================================

const Stack = createStackNavigator();

export default function App() {
  return (
    <Provider store={store}>
      <NavigationContainer>
        <Stack.Navigator>
          <Stack.Screen
            name="Home"
            component={Sidebar}
            options={{ title: "Welcome" }}
          />
          <Stack.Screen
            name="Map"
            component={Map}
            options={{ title: "Map" }}
          />
        </Stack.Navigator>
      </NavigationContainer>
    </Provider>
  );
}
