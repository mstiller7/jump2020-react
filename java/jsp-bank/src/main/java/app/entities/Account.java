package app.entities;

import java.util.ArrayList;

public class Account {
	
	private String name;
	private String password;
	private int balance;
	private ArrayList<Transaction> transactions;
	
	public Account() {
	}
	
	public Account(String name, String password) {
		this.name = name;
		this.password = password;
		this.transactions = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}
	
	public void recordTransaction(Transaction t) {
		transactions.add(t);
		if (transactions.size() > 5) {
			transactions.remove(0);
		}
	}
	
	@Override
	public String toString() {
		return "Account{" +
			       "name='" + name + '\'' +
			       ", password='" + password + '\'' +
			       ", balance=" + balance +
			       '}';
	}
	
}
