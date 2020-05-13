package practice;

import java.util.Scanner;

public class TimeConverter {

	public static void main(String[] args) {
		
		Scanner stdin = new Scanner(System.in);
		
		System.out.println("Enter the number of seconds: ");
		int seconds = stdin.nextInt();
		
		stdin.close();
		
		// convert to number of hours, minutes & seconds
		// seconds = seconds
		// minutes = seconds / 60 without rounding
		// hours = minutes / 60 without rounding
		
		// first, we will divide seconds into minutes and keep the remainder
		int minutes = seconds / 60;
		seconds %= 60;
		
		// then, we will divide minutes into hours and keep that remainder
		int hours = minutes / 60;
		minutes %= 60;
		
		System.out.println("That amount of seconds equals: " + hours + "hrs" + minutes + "min" + seconds + "sec");

	}

}
