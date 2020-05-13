package practice;

import java.util.Scanner;

public class StringFlipper {
	
	public static void main(String[] args) {
		
		Scanner stdin = new Scanner(System.in);
		System.out.println("Enter the word to be flipped: ");
		String og = stdin.nextLine().trim();
		stdin.close();
		
		String flipped = "";
		for (int i = og.length()-1; i >= 0; i--) {
			flipped += og.charAt(i);
		}
		System.out.println(flipped);
		
	}

}
