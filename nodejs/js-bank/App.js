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
  log(INFO("Please choose:"));
  log("1. Open Account");
  log("2. Login");
  var response = await io.read();
  log(WARN("You entered: ") + response);
}

function Create() {}

function Login() {}

function Transaction() {}

// helper functions.

function log(string) {
  console.log(string);
}
