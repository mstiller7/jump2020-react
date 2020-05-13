package maps;

import java.util.HashMap;
import java.util.Map;

public class MapsExample {

	public static void main(String[] args) {

		Map<Integer, String> hashmap = new HashMap<>();

		String[] foods = { "apple", "banana", "carrot", "egg", "onion" };
		{
			int i = 0;

			for (String s : foods) {
				hashmap.put(i, s);
				i++;
			}
		}

		// entrySet() will return the entries in a set
//		for (Map.Entry<Integer, String> food : hashmap.entrySet()) {
//
//		}

		// using a lambda expression instead
		hashmap.forEach((k, v) -> {
			System.out.println(k + ":" + v);
		});
		
		// returns keys as Set
		System.out.println(hashmap.keySet());

	}

}
