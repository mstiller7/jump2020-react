package net.mstiller.dollars.controller;

import net.mstiller.dollars.model.Account;
import net.mstiller.dollars.util.Console;

import static net.mstiller.dollars.util.Colors.*;

import java.util.ArrayList;

public class DollarsBankController {
	
	private ArrayList<Account> accounts = new ArrayList<>();
	private Account user;
	
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

//		Create a new account based on the given user inputs.
		user = new Account(
		Console.getString("Customer Name:"),
		Console.getString("Customer Address:"),
		Console.getString("Customer Contact Number:"),
		Console.getInt("User ID:"),
		Console.getString("Password: (8 characters with lower, upper & special)"),
		Console.getInt("Initial Deposit Amount:"));
		
		accounts.add(user);
		
		System.out.println("Account added!");
		System.out.println(user);

//		Clear the values and return to the landing screen.
		user = null;
		landing();
		
	}
	
	public void login() {
	
	}
	
	public void exit() {
		Console.paintLine(ANSI_RED, "Thank you for using DollarsBank! Closing.");
		System.exit(0);
	}
	
}
