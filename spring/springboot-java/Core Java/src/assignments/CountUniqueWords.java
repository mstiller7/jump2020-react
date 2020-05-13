package assignments;

import java.util.TreeMap;

public class CountUniqueWords {
	
	public static void main(String[] args) {
		
		TreeMap<String, Integer> map = counter(" Hello HELLO worlD WORld hi ");
		
		for (String k : map.keySet()) {
			System.out.println(k + ": " + map.get(k));
		}
		
		
		
	}
	
	public static TreeMap<String, Integer> counter(String s) {
		
		// lowercase the string, trim whitespace and split it
		// then add them all to a treemap

		String[] strings = s.toLowerCase().trim().split(" ");
		
		TreeMap<String, Integer> map = new TreeMap<>();
		
		for (String w : strings) {
			if (map.containsKey(w)) map.put(w, map.get(w)+1);
			else map.put(w, 1);
		}
		
		return map;
		
	}

}
