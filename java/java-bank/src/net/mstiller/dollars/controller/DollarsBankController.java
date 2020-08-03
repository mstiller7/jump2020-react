package net.mstiller.dollars.controller;

import net.mstiller.dollars.model.Account;
import net.mstiller.dollars.model.Deposit;
import net.mstiller.dollars.model.Transaction;
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
		Console.getString("User ID:"),
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
		
		Console.splashLogin();
		String id = Console.getString("User ID:");
		String pw = Console.getString("Password:");

//		iterate through current accounts to see if the specified account exists.
		for (Account a : accounts) {
			if (a.id.equals(id) && a.password.equals(pw)) {
				user = a;
				selection();
			} else {
				Console.paintLine(ANSI_RED, "Invalid credentials. Please retry.");
				login();
			}
		}
		
	}
	
	public void selection() {
		
		Console.splashLoggedIn();
		switch (Console.getInt("")) {
			case 1 -> opDeposit();
			case 2 -> opWithdraw();
			case 3 -> opTransfer();
			case 4 -> opRecent();
			case 5 -> opInfo();
			case 6 -> opLogout();
//			Invalid choice, re-show screen.
			default -> {
				Console.paintLine(ANSI_RED, "Unknown choice.");
				selection();
			}
		}
		
	}
	
	public void opDeposit() {
		
		int amount = Console.getInt("Enter amount to deposit:");
		user.recordTransaction(new Deposit(user, amount));
		System.out.println("Transaction successful:");
		System.out.println(user.transactions.get(user.transactions.size()-1));
		selection();
	
	}
	
	public void opWithdraw() {
	
	}
	
	public void opTransfer() {
	
	}
	
	public void opRecent() {
		
		for (Transaction t : user.transactions) {
			System.out.println(t);
		}
		
	}
	
	public void opInfo() {
	
	}
	
	public void opLogout() {
	
	}
	
	public void exit() {
		Console.paintLine(ANSI_RED, "Thank you for using DollarsBank! Closing.");
		System.exit(0);
	}
	
}
