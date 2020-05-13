package practice.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherExample {

	public static void main(String[] args) {

		// regex pattern
		String regex = "ba*b"; // bb, bab, baab...
		
		// regex pattern class (compiles the regex for Java's purposes)
		Pattern pattern = Pattern.compile(regex);
		
		// String to test regex
		String test = "baaaabc";
		
		// matcher created to check regex against a String
		Matcher matcher = pattern.matcher(test);
		
		// check if matches regex
		if (matcher.matches()) {
			System.out.println("regex matches");
		} else
			System.out.println("regex doesn't match");
		
		// returns true if substring matches.
		// returns false if entire string matches.
		if (matcher.find()) {
			System.out.println("regex found");
		} else
			System.out.println("regex not found");
		
	}

}
