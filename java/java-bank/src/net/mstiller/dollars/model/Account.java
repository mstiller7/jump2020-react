package net.mstiller.dollars.model;

public class Account {
	
	public int id;
	public String password;
	public int balance;
	
	public Account(int id, String password, int balance) {
		this.id = id;
		this.password = password;
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "Account{" +
		"id=" + id +
		", password='" + password + '\'' +
		", balance=" + balance +
		'}';
	}
}
