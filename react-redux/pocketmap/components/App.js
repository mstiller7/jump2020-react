// * =================================================================
// * Imports
// * =================================================================

// React/Native
import * as React from "react";
import { Component } from "react";
import { View } from "react-native";
import "react-native-gesture-handler";
import {
  NavigationContainer,
} from "@react-navigation/native";
import { createStackNavigator } from "@react-navigation/stack";
import { createDrawerNavigator } from "@react-navigation/drawer";
// Redux
import { createStore, combineReducers } from "redux";
import { Provider } from "react-redux";
// Reducer functions
import userReducer from "./functions/UserReducer";
// Components
import Landing from "./Landing/Landing";
import Sidebar from "./Sidebar/Sidebar";
import Map from "./Map/Map";

// * =================================================================
// * Functional setup
// * =================================================================

// combine all reducers.
const store = createStore(
  combineReducers({
    // user: userReducer,
  })
);

store.subscribe(() => {
  // console.log("Store changed:", store.getState());
  // do stuff here
});

// store.dispatch({ type: "CHANGE_USER", payload: "Matthew" });

// * =================================================================
// * App rendering
// * =================================================================

const Stack = createStackNavigator();
const Drawer = createDrawerNavigator();

export default class App extends Component {
  
  render() {
    return (
      <Provider store={store}>
        <NavigationContainer>
          <Stack.Navigator initialRouteName="Landing">
            <Stack.Screen name="Landing" component={Landing} title="Welcome" />
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
}

function Buttons({ navigation }) {
  return (
    <View>
      <Text>"This is some text.</Text>
      {/* <Button title="Menu" onPress={navigation.openDrawer()} /> */}
    </View>
  );
}
