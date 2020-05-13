package exercises;

public class StringDeduper {

	public static void main(String[] args) {

//		If given a String, remove any repeating characters next to each other.
//		e.g. "aabbcab" -> "abcab"; "baaab" -> "bab"

		System.out.println(dedupeString("aabbcab"));
		System.out.println(dedupeString("baaab"));
		System.out.println(dedupeString("matthew"));

	}

	public static String dedupeString(String s) {

		// iterate through the string one letter at a time, copy a character to a new
		// String, and check the immediate next letter.
		// if the next letter is the same as the current one, *skip it and keep going.

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {

			// store the current char in memory.
			char c = s.charAt(i);

			// for the first char, we assume it's fine to store...
			sb.append(c);

			// if the next letter is the same, skip over it. then test the next one, etc.
			// order of logic-checking is important here... don't try to find a charAt() an invalid index!
			while (i < s.length()-1 && c == s.charAt(i + 1)) {
				i++;
			}

		}

		return sb.toString();

	}

}
