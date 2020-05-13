package practice.regex;

public class ReplaceAllMethod {

	public static void main(String[] args) {
		
		String sentence = "Hello, how are you?";
		
		
		
		String newSentence = sentence.replaceAll("\\s[a-z]", " *");
		
		System.out.println(newSentence);
		
		
		// make everything titlecase
		StringBuilder sb = new StringBuilder(sentence);
		
		for (int i = 0; i < sb.length(); i++) {
			
			sb.charAt(i);
			
		}
		
	}
	
}
