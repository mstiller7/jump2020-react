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
		paintLine(ANSI_GREEN, "Enter Choice (1, 2, or 3):");
	}
	
	public static void splashNewAccount() {
		paintLine(ANSI_BLUE, "+ ----------------------------- +");
		paintLine(ANSI_BLUE, "| Enter Details for New Account |");
		paintLine(ANSI_BLUE, "+ ----------------------------- +");
	}
	
	public static int getChoice() {
		return stdin.nextInt();
	}
	
	
}
