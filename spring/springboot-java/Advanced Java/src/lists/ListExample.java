package lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListExample {
	
	public static void main(String[] args) {
		
		ArrayList<String> fruits = new ArrayList<>();
		
		fruits.add("apple");
		fruits.add("mango");
		
		System.out.println(fruits);
		
		
		// better future-proofing to not explicitly
		// make it a specific type (ArrayList, etc.)
		List<String> fruits2 = new LinkedList<>();
		
		fruits2.add("apple");
		fruits2.add("mango");
		
		System.out.println(fruits2);
		
		
		for (String s : fruits2) {
			System.out.println(s);
		}
		
		fruits2.remove(1);
		System.out.println(fruits2);
		
		fruits2.clear();
		System.out.println(fruits2);
		
	}

}
