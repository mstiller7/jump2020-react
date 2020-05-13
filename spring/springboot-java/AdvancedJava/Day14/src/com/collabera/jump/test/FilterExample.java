package com.collabera.jump.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterExample {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("name3", "", "name1", "name10", "", "name100");

		List<String> filtered = names.stream()
				.filter(z -> z.startsWith("n"))
				.collect(Collectors.toList());

		String[] data = names.stream()
				.filter(e -> !e.isEmpty())
				//.parallel()
				.map(e -> "Your name is: " + e)
				.limit(2)
				.sorted()
				.toArray(String[]::new);

		System.out.println(Arrays.toString(data));

		// .forEach(System.out::println);

		// filtered.forEach(System.out::println);
	}
}
