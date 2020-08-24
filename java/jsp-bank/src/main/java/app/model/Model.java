package app.model;

import app.entities.Account;
import app.entities.Deposit;

import java.util.ArrayList;

public class Model {
	
	private static Model instance = new Model();
	private final ArrayList<Account> ACCOUNTS;
	private static Account user;
	
	public static Model getInstance() {
		if (instance == null) { instance = new Model(); }
		return instance;
	}
	
	private Model() {
		ACCOUNTS = new ArrayList<>();
		Account test = new Account("test", "test");
		add(test);
		test.recordTransaction(new Deposit(test, 1000));
	}
	
	public ArrayList<Account> getAccounts() {
		return ACCOUNTS;
	}
	
	public void add(Account account) {
		ACCOUNTS.add(account);
	}
	
	public Account getUser() {
		return user;
	}
	
	public void setUser(Account user) {
		Model.user = user;
	}
	
}
