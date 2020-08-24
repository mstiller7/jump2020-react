package app.model;

import app.entities.Account;

import java.util.ArrayList;

public class Model {
	
	private static final ArrayList<Account> ACCOUNTS = new ArrayList<>();
	private static Account user;
	
	public static ArrayList<Account> getAccounts() {
		return ACCOUNTS;
	}
	
	public static void add(Account account) {
		ACCOUNTS.add(account);
	}
	
	public static Account getUser() {
		return user;
	}
	
	public static void setUser(Account user) {
		Model.user = user;
	}
	
}
