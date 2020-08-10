import Account from "./src/Account.js";

import clc from "cli-color";

var error = clc.red.bold.italic;
var warn = clc.yellow.italic;
var notice = clc.blue.bold;
var success = clc.greenBright.bold;

var account;

function init() {
  Menu();
}

init();

// procedural functions.

function Menu() {
  log(success("DollarsBank ATM welcomes you!"));
  log("Please choose:");
  log("1. Open Account");
  log("2. Login");
}

function Create() {}

function Login() {}

function Transaction() {}

// helper functions.

function log(string) {
  console.log(string);
}
