package net.mstiller.dollars.model;

public class Deposit extends Transaction {
	
	public Deposit(Account account, int amount) {
		super();
		amtStart = account.balance;
		amtDiff = amount;
		amtEnd = account.balance + amount;
		account.balance = amtEnd;
	}
	
	@Override
	public String toString() {
		return "Deposited $" + amtDiff + " ($" + amtStart + " -> $" + amtEnd + ") on " + timestamp;
	}
	
}
