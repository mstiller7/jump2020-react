package net.mstiller.dollars.model;

public class Account {
	
	public String name, address, phone;
	public int id;
	public String password;
	public int balance;
	
	public Account(String name, String address, String phone, int id, String password, int balance) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.id = id;
		this.password = password;
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "Account{" +
		"name='" + name + '\'' +
		", address='" + address + '\'' +
		", phone='" + phone + '\'' +
		", id=" + id +
		", password='" + password + '\'' +
		", balance=" + balance +
		'}';
	}
	
}
