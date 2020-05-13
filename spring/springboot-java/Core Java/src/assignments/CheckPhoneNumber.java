package assignments;

import java.util.Scanner;

public class CheckPhoneNumber {
	
	public static void main(String[] args) {
		
		Scanner stdin = new Scanner(System.in);
		System.out.println("Enter a phone number: ");
		String input = stdin.nextLine().toLowerCase().trim();
		input = input.replace("-", "");
		input = input.replace("(", "");
		input = input.replace(")", "");
		
		if (input.contains("911")) {
			System.out.println("Invalid; contains 911.");
			stdin.close();
			return;
		}
		
		char[] chars = input.toCharArray();
		for (int i = 0; i < input.length()-2; i++) {
			if (chars[i] == '9') {
				if (chars[i+1] == '1') {
					if (chars[i+2] == '1') {
						System.out.println("Invalid; contains 911.");
						stdin.close();
						return;
					}
				}
			}
		}
		
		System.out.println("Valid phone number.");
		stdin.close();
		
	}

}
