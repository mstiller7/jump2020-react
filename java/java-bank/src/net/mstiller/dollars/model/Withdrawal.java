package net.mstiller.dollars.model;

public class Withdrawal extends Transaction {
	
	public Withdrawal(Account account, int amount) {
		super();
		amtStart = account.balance;
		amtDiff = amount;
		amtEnd = account.balance - amount;
//		If the balance would be negative, void the transaction.
		if (amtEnd < 0) {
			amtEnd = amtStart;
		}
		account.balance = amtEnd;
	}
	
	@Override
	public String toString() {
		return "Withdrew $" + amtDiff + " ($" + amtStart + " -> $" + amtEnd + ") on " + timestamp;
	}
	
}
