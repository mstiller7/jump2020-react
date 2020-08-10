import clc from "cli-color";
import io from "console-read-write";

import Account from "./src/Account.js";

const ERROR = clc.red.bold.italic;
const WARN = clc.yellow.italic;
const INFO = clc.blue;
const SUCCESS = clc.greenBright.bold;

var account;

function init() {
  Menu();
}

init();

// procedural functions.

async function Menu() {
  log(SUCCESS("DollarsBank ATM welcomes you!"));
  log(INFO("Please enter a numeric choice:"));
  log("1. Open Account");
  log("2. Login");
  switch (parseInt(await io.read())) {
    case 1:
      Create();
      break;
    case 2:
      Login();
      break;
    default:
      log(ERROR("Unknown entry. Please retry."));
      Menu();
  }
}

function Create() {
  log("You chose to create a new account.");
  Menu();
}

function Login() {
  log("You chose to login.");
  Menu();
}

function Transaction() {}

// helper functions.

function log(string) {
  console.log(string);
}
