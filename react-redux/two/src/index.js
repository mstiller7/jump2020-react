import React, { Component, Fragment, useState, useEffect } from "react";
import ReactDOM from "react-dom";

export default class App extends Component {

  render() {
    return (
      <div>
        <Counter />
      </div>
    );
  }
}

function Counter() {
  // defines "count" and a function "setCount" to update the count var
  const [count, setCount] = useState(0);
  // useEffect(() => { console.log("Clicked!") });

  return (
    <Fragment>
      <h1>{count}</h1>
      <button onClick={() => setCount(count + 1)}>Add</button>
    </Fragment>
  )
}

// class App extends Component {
//   render() {
//     return (
//       <div>
//         <Header />
//         <Terminal />
//       </div>);
//   }
// }

class Terminal extends Component {
  state = {
    character: "",
    loading: false,
    isLoggedIn: false,
  };

  componentDidMount() {
    fetch("https://ipinfo.io/json")
      .then((response) => response.json())
      .then((data) => {
        this.setState({ loading: false, character: data });
      });
  }

  toggleLogged = () => {
    this.setState((state) => {
      return {
        isLoggedIn: !state.isLoggedIn,
      };
    });
  };

  render() {
    return (
      <Fragment>
        <p>You are: {this.state.isLoggedIn ? "Logged In" : "Logged Out"}</p>
        <button onClick={this.toggleLogged}>
          {this.state.isLoggedIn ? "Log Out" : "Log In"}
        </button>
        <p>{this.state.loading ? "Loading" : this.state.character.city}</p>
      </Fragment>
    );
  }
}

// =================================================================

class Body extends Component {
  state = {
    message: "Loading...",
    imgsrc: "https://i.imgur.com/ulhIDCW.gifv",
  };

  changeState = (props) => {
    this.setState(() => {
      return {
        message: props[0],
        imgsrc: props[1],
      };
    });
  };

  componentWillMount() { }

  componentDidMount() {
    setTimeout(() => {
      this.changeState(["Your page has loaded", ""]);
    }, 1500);
  }
  render() {
    return (
      <div>
        <p>Page Status: {this.state.message}</p>
        <img src={this.state.imgsrc} alt="" />
      </div>
    );
  }
}

// #2
class Header extends Component {
  render() {
    return <h1>Status Dashboard</h1>;
  }
}

class Footer extends Component {
  render() {
    return <p style={sFooter}>There are 3 feet to a yard.</p>;
  }
}

const sFooter = {
  fontSize: 12,
  fontStyle: "oblique",
};

// #3
// class Greeting extends Component {
//   render() {
//     const date = new Date();
//     const hours = date.getHours();
//     let timeOfDay;
//     if (hours < 12) {
//       timeOfDay = "morning";
//     } else if (hours >= 12 && hours < 17) {
//       timeOfDay = "afternoon";
//     } else {
//       timeOfDay = "night";
//     }
//     return <h1>Good {timeOfDay} to you, sir or madam!</h1>;
//   }
// }

// class Sandbox extends Component {

//   componentDidMount() {
//     console.log("mounted");
//   }
//   componentDidUpdate() {
//     console.log("updated");
//   }

//   changeState = () => {
//     this.setState((prevState) => {
//       return {
//         username: prevState.username + "StateChanged"
//       }
//     });
//   }

//   handleDrag = () => {
//     console.log("I'm being moved!");
//   }
//   handleClick = () => {
//     console.log("I was clicked!");
//   }
//   handleHover = () => {
//     console.log("I was hovered over!");
//   }

//   toggleLogin = () => {
//     this.setState(state => ({
//       isLoggedIn: !state.isLoggedIn
//     }));
//   }
//   render() {
//     return (
//       <div>
//         <p>You are logged: {this.state.isLoggedIn ? "in" : "out"}</p>
//         <img onDrag={this.handleDrag} alt="Fill Murray" onMouseOver={this.handleHover} src="https://www.fillmurray.com/200/100" /><br /><br />
//         <button onClick={this.handleClick}>Click Me</button>
//         <button onClick={this.changeState}>Login</button>
//       </div>
//     );
//   }
// }

const style = {
  fontSize: 30,
  color: "white",
  backgroundColor: "red",
  fontStyle: "oblique",
};

ReactDOM.render(<App />, document.getElementById("root"));
