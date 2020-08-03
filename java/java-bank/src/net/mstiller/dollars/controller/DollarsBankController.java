package net.mstiller.dollars.controller;

import net.mstiller.dollars.model.Account;
import net.mstiller.dollars.model.Deposit;
import net.mstiller.dollars.model.Transaction;
import net.mstiller.dollars.model.Withdrawal;
import net.mstiller.dollars.util.Console;

import static net.mstiller.dollars.util.Colors.*;

import java.util.ArrayList;

public class DollarsBankController {
	
	private final ArrayList<Account> accounts = new ArrayList<>();
	private Account user;
	
	public void init() {
		
		landing();
		
	}
	
	public void landing() {
		
		Console.splashWelcome();
		
		switch (Console.getInt("")) {
			case 1 -> createAccount();
			case 2 -> login();
			case 3 -> exit();
			default -> {
				Console.alert("Error. Please retry.");
				landing();
			}
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
		
		Console.success("Account added!");
		System.out.println(accounts);

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
			}
		}
//			If we've looped through all users and not found anyone, they don't exist.
		Console.alert("Invalid credentials. Please retry.");
		login();
		
	}
	
	public void selection() {
		
		Console.splashLoggedIn();
		switch (Console.getInt("")) {
			case 1 -> {
				opDeposit();
				selection();
			}
			case 2 -> {
				opWithdraw();
				selection();
			}
			case 3 -> {
				opTransfer();
				selection();
			}
			case 4 -> opRecent();
			case 5 -> opInfo();
			case 6 -> opLogout();
//			Invalid choice, re-show screen.
			default -> {
				Console.alert("Unknown choice.");
				selection();
			}
		}
		
	}
	
	public int opDeposit() {
		
		int amount = Console.getInt("Enter amount to deposit:");
		Transaction t = user.recordTransaction(new Deposit(user, amount));
		if (t.status == Transaction.STATUS.VOID) {
			Console.alert("There was an error in your deposit amount, and your transaction has been voided.");
		} else {
			Console.success("Transaction successful:");
			Console.success(user.transactions.get(user.transactions.size() - 1).toString());
		}
		return t.amtDiff;
		
	}
	
	public int opWithdraw() {
		
		int amount = Console.getInt("Enter amount to withdraw:");
		Transaction t = user.recordTransaction(new Withdrawal(user, amount));
		if (t.status == Transaction.STATUS.VOID) {
			Console.alert("There was an error, and your transaction has been voided.");
			Console.alert("Please ensure your account has enough balance to cover the withdrawal.");
		} else {
			Console.success("Transaction successful:");
			Console.success(user.transactions.get(user.transactions.size() - 1).toString());
		}
		return t.amtDiff;
		
	}
	
	public void opTransfer() {
		
		String id = Console.getString("Enter account to transfer to: ");
		for (Account a : accounts) {
			if (a.id.equals(id)) {
				int amount = Console.getInt("Enter amount to transfer to account '" + a.id + "':");
				Transaction withdrawal = user.recordTransaction(new Withdrawal(user, amount));
				Transaction deposit = user.recordTransaction(new Deposit(a, withdrawal.amtDiff));
				return;
			}
		}
		Console.alert("No such account was found. Try again.");
		
		
	}
	
	public void opRecent() {
		
		for (Transaction t : user.transactions) {
			System.out.println(t);
		}
		selection();
		
	}
	
	public void opInfo() {
		
		Console.splashDetails();
		System.out.println(user);
		selection();
		
	}
	
	public void opLogout() {
		
		user = null;
		Console.alert("You have logged out.");
		landing();
		
	}
	
	public void exit() {
		Console.alert("Thank you for using DollarsBank! Closing.");
		System.exit(0);
	}
	
}
