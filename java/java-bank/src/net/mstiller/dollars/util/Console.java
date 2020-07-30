package net.mstiller.dollars.util;

import static net.mstiller.dollars.util.Colors.*;

public class Console {

//	Color helpers.
	
	public static void paint(String color, String input) {
		System.out.print(color + input + ANSI_RESET);
	}
	
	public static void paintLine(String color, String input) {
		paint(color, input);
		System.out.println();
	}

//	Splash helpers.
	
	public static void printWelcome() {
		paintLine(ANSI_BLUE, "+ ------------------------- +");
		paintLine(ANSI_BLUE, "| DOLLARSBANK WELCOMES YOU! |");
		paintLine(ANSI_BLUE, "+ ------------------------- +");
		System.out.println("1. Create New Account");
		System.out.println("2. Login");
		System.out.println("3. Exit");
	}
	
	public void printNewAccount() {
	
	}
	
	
}
