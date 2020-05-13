package practice.regex;

public class StringMatchMethod {

	public static void main(String[] args) {
		
		String regex = "ba*b";
		String test = "baaab";
		
		if (test.matches(regex)) {
			System.out.println("regex matches");
		} else {
			System.out.println("regex doesn't match");
		}
		
		if ("bb".matches(regex)) {
			System.out.println("regex matches");
		} else {
			System.out.println("no match");
		}
		
		
	}
	
	
}
