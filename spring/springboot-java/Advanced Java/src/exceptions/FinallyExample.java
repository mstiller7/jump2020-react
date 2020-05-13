package exceptions;

import java.util.Scanner;

public class FinallyExample {

	public static void main(String[] args) {

		try (Scanner in = new Scanner(System.in)) {
			System.out.println(100 / 0);
			System.exit(0);
			in.nextLine();
		} catch (Exception e) {
			System.out.println("Caught the error.");
		} finally {
			System.out.println("This will run no matter what.");
		}

	}

}
