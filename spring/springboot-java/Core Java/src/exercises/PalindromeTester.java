package exercises;

public class PalindromeTester {

	public static void main(String[] args) {
		
		// Write a method that will return whether a String is a palindrome.
		
		// examples:
		// "bob" -> "bob", is a palindrome
		// "hannah" -> "hannah", is also a palindrome
		// "matthew" -> "wehttam", not a palindrome
		// "reviver" -> "reviver", is a palindrome
		// "Murder for a jar of red rum" is a palindrome, apparently...
		
		System.out.println(isPalindrome("bob"));
		System.out.println(isPalindrome("hannah"));
		System.out.println(isPalindrome("matthew"));
		System.out.println(isPalindrome("reviver"));
		System.out.println(isPalindrome("Murder for a jar of red rum"));

	}
	
	public static boolean isPalindrome(String s) {
		
		// assuming capitalization doesn't matter, but this is here to practice with.
		// could use .trim() too, but this is to remove all spaces, such as for sentences. (Jason)
		s = s.toLowerCase().replaceAll("\\s+","");
		
		// a few ways to go about this:
		// 1) make a copy of the string, reverse it, and then compare the two
		// 2) iterate forwards and backwards across the string at the same time (up to midpoint minus one; middle character will be the same)
		// let's do the second, since it probably saves memory and processing power/time with larger quantities.
		
		// proceed to the middle character of the String and test it, then end
		for (int i = 0; i < s.length()/2; i++) {
			// if there's any characters that don't match each other, we know it's not a palindrome.
			if (s.charAt(i) != s.charAt(s.length()-1-i)) {
				return false;
			}
		}
		
		// if there were no failures, it is a palindrome.
		return true;
		
	}

}
