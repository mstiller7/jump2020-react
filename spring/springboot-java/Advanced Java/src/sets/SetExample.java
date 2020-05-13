package sets;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {
	
	public static void main(String[] args) {
		
		Set<String> fruitsTree = new TreeSet<>();
		Set<String> fruitsHash = new HashSet<>();
		
		String[] fruitsArr = { "banana", "mango", "apple",
				"orange", "grapes", "apple", "banana", "orange",
				"berries" };
		
		for (String s : fruitsArr) {
			fruitsTree.add(s);
			fruitsHash.add(s);
		}
		
		System.out.println("Tree = " + fruitsTree);
		System.out.println("Hash = " + fruitsHash);
		
		System.out.println("Set size = " + fruitsTree.size());
		System.out.println("Contains apple? " + fruitsTree.contains("apple"));
		
		Iterator<String> iterFruit = fruitsHash.iterator();
		
		while(iterFruit.hasNext()) {
			System.out.println(iterFruit.next());
		}
		
		
	}

}
