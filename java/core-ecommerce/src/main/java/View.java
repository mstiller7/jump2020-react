import java.util.Scanner;

public class View {
	
	public static final Scanner STDIN = new Scanner(System.in);
	
	//	Painters.
	
	public static final String
		ANSI_RESET = "\u001B[0m",
		ANSI_RED = "\u001B[31m",
		ANSI_GREEN = "\u001B[32m",
		ANSI_BLUE = "\u001B[34m";
	
	public static void paint(String color, String input) {
		System.out.print(color + input + ANSI_RESET);
	}
	
	public static void paintLine(String color, String input) {
		paint(color, input);
		System.out.println();
	}
	
	//	Splash helpers.
	
	public static void splashLanding() {
		info("+ ---------------------------------- +");
		info("| CORE-ECOMMERCE: YOUR SHOPPING SITE |");
		info("+ ---------------------------------- +");
		System.out.println("1. Register");
		System.out.println("2. Login");
	}
	
	public static void splashRegister() {
		info("+ --------------------- +");
		info("| CUSTOMER REGISTRATION |");
		info("+ --------------------- +");
	}
	
	//	Notices.
	
	public static void alert(String alert) {
		paintLine(ANSI_RED, alert);
	}
	
	public static void success(String success) {
		paintLine(ANSI_GREEN, success);
	}
	
	public static void info(String info) {
		paintLine(ANSI_BLUE, info);
	}
	
	//	Prompt helpers.
	
	public static int getInt(String prompt) {
		info(prompt);
		try {
			return Integer.parseInt(STDIN.nextLine());
		} catch (Exception e) {
			alert("Invalid input.");
			return getInt(prompt);
		}
	}
	
	public static String getString(String prompt) {
		info(prompt);
		try {
			return STDIN.nextLine();
		} catch (Exception e) {
			alert("Invalid input.");
			return getString(prompt);
		}
		
	}
	
}
