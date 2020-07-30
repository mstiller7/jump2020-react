package net.mstiller.dollars.controller;

import net.mstiller.dollars.model.Account;
import net.mstiller.dollars.model.Customer;
import net.mstiller.dollars.util.Console;

import java.util.ArrayList;
import java.util.HashMap;

public class DollarsBankController {
	
	private HashMap<Customer, ArrayList<Account>> customers = new HashMap<>();
	private Customer currentCustomer;
	private Account currentAccount;
	
	public void init() {
		
		landing();
		
	}
	
	public void landing() {
		
		Console.splashWelcome();
		
		switch (Console.getInt("")) {
			case 1 -> createAccount();
			case 2 -> login();
			default -> exit();
		}
		
	}
	
	public void createAccount() {
		
		Console.splashNewAccount();

//		Create a new Customer based on the given user inputs.
		currentCustomer = new Customer(
		Console.getString("Customer Name:"),
		Console.getString("Customer Address:"),
		Console.getString("Customer Contact Number:")
		);

//		Create a new account based on the given user inputs.
		currentAccount = new Account(
		Console.getInt("User ID:"),
		Console.getString("Password: (8 characters with lower, upper & special)"),
		Console.getInt("Initial Deposit Amount:"));

//		Add the new account to the customer's list of accounts.
//		First, if the customer doesn't exist, create the key.
		if (!customers.containsKey(currentCustomer)) {
			customers.put(currentCustomer, new ArrayList<>());
		}
		customers.get(currentCustomer).add(currentAccount);
		
		System.out.println("Account added!");
		System.out.println(currentCustomer);
		System.out.println(currentAccount);

//		Clear the values and return to the landing screen.
		currentCustomer = null;
		currentAccount = null;
		landing();
		
	}
	
	public void login() {
	
	}
	
	public void exit() {
		System.exit(0);
	}
	
}
