package exceptions;

public class BankAccount {

	public enum AccountType {
		CHECKING, SAVINGS
	}

	private int balance;
	private AccountType accountType;

	public BankAccount(int balance, AccountType accountType) {
		super();
		this.balance = balance;
		this.accountType = accountType;
	}
	
	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public int getBalance() {
		return balance;
	}
	
	public void deposit(int amount) {
		
		if (amount > 0) {
			this.balance += amount;
		} else {
			
		}
		
		
	}
	
	public void withdraw(int amount) throws OverdraftException {
		
		if (amount > balance) {
			throw new OverdraftException(amount, balance);
		}
		
		this.balance -= amount;
	}

}
