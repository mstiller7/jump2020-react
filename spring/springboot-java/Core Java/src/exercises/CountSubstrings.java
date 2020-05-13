package exercises;

public class CountSubstrings {
	
	public static void main(String[] args) {

		System.out.println(countSubs("Hi HelloHi Hi", "Hi"));
				
	}
	
	
	public static int countSubs(String string, String sub) {
		
		int count = 0;
		
		// let's use a StringBuilder to remove segments of the original String
		StringBuilder sb = new StringBuilder(string);
		
		// get the index of the substring if it exists and then delete it
		while (sb.indexOf(sub) > -1) {
			sb.delete(sb.indexOf(sub), sb.indexOf(sub)+sub.length());
			count++;
		}
		
		return count;
		
	}
	

}
