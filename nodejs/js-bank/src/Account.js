export default class Account {
  constructor(name, pin, deposit) {
    this.name = name;
    this.pin = pin;
    this.balance = 0;
    this.transactions = [];
    this.makeDeposit(deposit);
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
    this.makeTransaction(
      parseInt(this.balance),
      (parseInt(this.balance) += parseInt(amount))
    );
    return this.getBalance();
  }

  makeWithdrawal(amount) {
    // this.balance -= amount;
    this.makeTransaction(
      parseInt(this.balance),
      (parseInt(this.balance) -= parseInt(amount))
    );
    return this.getBalance();
  }
}
