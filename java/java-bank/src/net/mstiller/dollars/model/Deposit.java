package net.mstiller.dollars.model;

public class Deposit extends Transaction {
	
	public Deposit(Account account, int amount) {
		super(account);
		amtStart = account.balance;
		amtDiff = amount;
		amtEnd = account.balance + amount;
		status = STATUS.SUCCESS;
		//		If the amount to be withdrawn would be negative, void the transaction.
		if (amtDiff < 0) {
			amtEnd = amtStart;
			status = STATUS.VOID;
		}
		account.balance = amtEnd;
	}
	
	@Override
	public String toString() {
		return "[" + status + "] ACCOUNT '" + user + "' DEPOSITED $" + amtDiff + " ($" + amtStart + " -> $" + amtEnd + ") on " + timestamp;
	}
	
}
