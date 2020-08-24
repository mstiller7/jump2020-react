package app.entities;

public class Withdrawal extends Transaction {
	
	public Withdrawal(Account account, int amount) {
		super(account);
		amtStart = account.getBalance();
		amtDiff = amount;
		amtEnd = account.getBalance() - amount;
		status = STATUS.SUCCESS;
		//	If the amount to be withdrawn or balance would be negative, void the transaction.
		if (amtDiff < 0 || amtEnd < 0) {
			amtEnd = amtStart;
			status = STATUS.VOID;
		}
		account.setBalance(amtEnd);
	}
	
	@Override
	public String toString() {
		return "[" + status + "] ACCOUNT '" + user + "' WITHDREW $" + amtDiff + " ($" + amtStart + " -> $" + amtEnd + ") " +
			       "on " + timestamp;
	}
	
}
