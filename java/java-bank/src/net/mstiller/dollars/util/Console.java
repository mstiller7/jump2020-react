package net.mstiller.dollars.util;

import java.util.Scanner;

import static net.mstiller.dollars.util.Colors.*;

public class Console {
	
	static Scanner stdin = new Scanner(System.in);

//	Color helpers.
	
	public static void paint(String color, String input) {
		System.out.print(color + input + ANSI_RESET);
	}
	
	public static void paintLine(String color, String input) {
		paint(color, input);
		System.out.println();
	}

//	Splash helpers.
	
	public static void splashWelcome() {
		paintLine(ANSI_BLUE, "+ ------------------------- +");
		paintLine(ANSI_BLUE, "| DOLLARSBANK WELCOMES YOU! |");
		paintLine(ANSI_BLUE, "+ ------------------------- +");
		System.out.println("1. Create New Account");
		System.out.println("2. Login");
		System.out.println("3. Exit");
		paint(ANSI_GREEN, "Enter Choice (1, 2, or 3):");
	}
	
	public static void splashNewAccount() {
		paintLine(ANSI_BLUE, "+ ----------------------------- +");
		paintLine(ANSI_BLUE, "| Enter Details for New Account |");
		paintLine(ANSI_BLUE, "+ ----------------------------- +");
	}
	
	public static void splashLogin() {
		paintLine(ANSI_BLUE, "+ ------------------- +");
		paintLine(ANSI_BLUE, "| Enter Login Details |");
		paintLine(ANSI_BLUE, "+ ------------------- +");
	}
	
	public static void splashLoggedIn() {
		paintLine(ANSI_BLUE, "+ ------------------------ +");
		paintLine(ANSI_BLUE, "| Welcome Valued Customer! |");
		paintLine(ANSI_BLUE, "+ ------------------------ +");
		System.out.println("1. Deposit Amount");
		System.out.println("2. Withdraw Amount");
		System.out.println("3. Funds Transfer");
		System.out.println("4. View 5 Recent Transactions");
		System.out.println("5. Display Customer Information");
		System.out.println("6. Sign Out");
		paint(ANSI_GREEN, "Enter Choice (1-6):");
	}
	
//	Prompt helpers.
	
	public static int getInt(String prompt) {
		System.out.println(prompt);
		try {
			return Integer.parseInt(stdin.nextLine());
		} catch (Exception e) {
			System.out.println("Invalid input.");
			return getInt(prompt);
		}
	}
	
	public static String getString(String prompt) {
		System.out.println(prompt);
		try {
			return stdin.nextLine();
		} catch (Exception e) {
			System.out.println("Invalid input.");
			return getString(prompt);
		}
		
	}
	
}
