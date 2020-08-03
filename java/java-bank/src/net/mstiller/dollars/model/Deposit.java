package net.mstiller.dollars.model;

public class Deposit extends Transaction {
	
	public int amount;
	
	public Deposit(Account account, int amount) {
		super();
		this.amount = amount;
		account.balance += amount;
	}
	
	@Override
	public String toString() {
		return "Deposited $" + amount + " on " + timestamp;
	}
	
}
