package practice.strings;

public class ChangingStrings {

	public static void main(String[] args) {

		String s = "Hello";

		for (int i = 0; i < 5; i++) {

			// each iteration, a new String Pool memory space is taken
			// not memory-efficient
			s += i;

		}

		System.out.println(s);

		// =========================================================

		StringBuilder sb = new StringBuilder("Hello");

		for (int i = 0; i < 5; i++) {

			// memory/processing-efficient. doesn't grow String Pool space unnecessarily.
			sb.append(i);

		}
		
		System.out.println(sb);

	}

}
