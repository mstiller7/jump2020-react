package exceptions;

import java.util.Scanner;

public class VotingRegistration {
	
	public static void main(String[] args) {
		
		System.out.println("Welcome, enter your age: ");
		
		Scanner sc = new Scanner(System.in);
		
		int age = sc.nextInt();
		
		if (age >= 18) {
			System.out.println("You may vote.");
		} else {
			System.out.println("You may not vote.");
		}
		
		sc.close();
		
	}

}
