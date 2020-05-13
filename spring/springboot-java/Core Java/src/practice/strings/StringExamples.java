package practice.strings;

public class StringExamples {

	public static void main(String[] args) {

		String str1 = "Hello"; // string pool
		String str2 = new String("Hello"); // heap memory
		String str3 = new String("Hello"); // second in heap memory
		String str4 = "Hello"; // second in string pool

		System.out.println(str1 == str2); // compares memory location
		System.out.println(str1.equals(str2)); // compares variable values
		System.out.println(str1 == str3); // both in heap, but different object instances
		System.out.println(str1 == str4); // both point to string pool

		// check for first vowel in a string
		String test = "mnbdfgrepoe";
		for (int i = 0; i < test.length(); i++) {
			
			char c = test.charAt(i);
			int index = -1;
			
			switch (c) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				// do things for successful vowel
				index = i;
				break;
				
			}
			
			if (index != -1) {
				System.out.println("First vowel at index " + index + " is " + c);
				break;
			}
			
		}

	}

}
