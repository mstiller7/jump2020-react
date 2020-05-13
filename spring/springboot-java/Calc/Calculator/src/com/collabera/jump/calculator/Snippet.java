package com.collabera.jump.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Snippet {
	public static void main(String[] args) {
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		filtered.forEach(System.out::println);

		List.of("This ", "is ", "created ", "by ", "List.of().parallelStream()")
		.parallelStream()
		.forEach(System.out::print);
	}
}