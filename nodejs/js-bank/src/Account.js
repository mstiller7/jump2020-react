export default class Account {
  constructor(deposit) {
    this.balance = 0;
    this.transactions = [];
    this.makeTransaction(deposit);
  }
  
  // updatePIN(pin) {
  //   this.pin = pin;
  // }

  getBalance() {
    return this.balance;
  }

  makeTransaction(amtStart, amtEnd) {
    var today = new Date();
    var date =
      today.getFullYear() +
      "-" +
      (today.getMonth() + 1) +
      "-" +
      today.getDate();
    var time =
      today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
    var dateTime = date + " " + time;
    this.transactions.push(
      "[" + dateTime + "] Transaction made: $" + amtStart + " -> $" + amtEnd
    );
  }

  makeDeposit(amount) {
    // this.balance += amount;
    this.makeTransaction(this.balance, (this.balance += amount));
    return this.getBalance();
  }

  makeWithdrawal(amount) {
    // this.balance -= amount;
    this.makeTransaction(this.balance, (this.balance -= amount));
    return this.getBalance();
  }
}
