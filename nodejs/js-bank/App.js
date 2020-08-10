import clc from "cli-color";
import io from "console-read-write";

import Account from "./src/Account.js";

const ERROR = clc.red.bold.italic;
const WARN = clc.yellow.italic;
const INFO = clc.blue;
const SUCCESS = clc.greenBright.bold;

var accounts = [];
var acctCurrent;

function init() {
  accounts.push(new Account("acct1", "acct1", 400));
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
      log(ERROR("Unknown entry. Please retry.\n"));
      Menu();
  }
}

async function Create() {
  log(WARN("You chose to create a new account.\n"));
  log(INFO("Enter account name:"));
  var name = await io.read();
  log(INFO("Enter account PIN:"));
  var pin = await io.read();
  log(INFO("Enter initial deposit:"));
  var balance = await io.read();

  acctCurrent = new Account(name, pin, balance);
  accounts.push(acctCurrent);
  log(SUCCESS("Account successfully created!\n"));

  AccountMenu();
}

async function Login() {
  log(WARN("You chose to login.\n"));
  log(INFO("Enter account name:"));
  var name = await io.read();
  log(INFO("Enter account PIN:"));
  var pin = await io.read();

  for (const account of accounts) {
    if (name == account.name && pin == account.pin) {
      acctCurrent = account;
      AccountMenu();
      return;
    }
  }

  log(ERROR("No such credentials were found. Please retry.\n"));
  Menu();
}

async function AccountMenu() {
  log(SUCCESS("=== Account Operation Menu ==="));
  log(INFO("Please enter a numeric choice:"));
  log("1. Check Balance");
  log("2. Transaction Record");
  log("3. Update PIN");
  log("4. Make Deposit");
  log("5. Make Withdrawal");
  log("6. Logout");
  switch (parseInt(await io.read())) {
    case 1:
      log(SUCCESS("Your balance is: $" + acctCurrent.balance + "\n"));
      AccountMenu();
      break;
    case 2:
      log(SUCCESS("These are the most recent transactions:"));
      var arr = acctCurrent.transactions;
      arr.reverse().forEach((t) => log(INFO(t)));
      log("\n");
      AccountMenu();
      break;
    case 3:
      UpdatePIN();
      break;
    case 4:
      MakeDeposit();
      break;
    case 5:
      MakeWithdrawal();
      break;
    case 6:
      Logout();
      break;
    default:
      log(ERROR("Unknown entry. Please retry.\n"));
      Menu();
  }
}

async function UpdatePIN() {
  log(INFO("Enter the new PIN value:"));
  var pin = await io.read();
  acctCurrent.pin = pin;
  log(SUCCESS("The account PIN was successfully updated."));
  AccountMenu();
}

async function MakeDeposit() {
  log(INFO("Enter the amount to be deposited:"));
  var amt = await io.read();
  var balance = acctCurrent.makeDeposit(amt);
  log(INFO("Deposit made. New balance: ") + balance);
  AccountMenu();
}

async function MakeWithdrawal() {
  log(INFO("Enter the amount to withdraw:"));
  var amt = await io.read();
  var balance = acctCurrent.makeWithdrawal(amt);
  log(INFO("Withdrawal made. New balance: ") + balance);
  AccountMenu();
}

function Logout() {
  log(WARN("You chose to logout.\n"));
  acctCurrent = null;
  log(SUCCESS("You have logged out. Thank you for visiting."));
  Menu();
}

// helper functions.

function log(string) {
  console.log(string);
}
