package functional.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamEx {
	public static void main(String[] args) {
		List<String> stringList = new ArrayList<String>();
		stringList.add("ONE");
		stringList.add("TWO");
		stringList.add("THREE");
		Stream<String> stream = stringList.stream();
		long count = stream.map((value) -> {
			return value.toLowerCase();
		}).map((value) -> {
			return value.toUpperCase();
		}).map((value) -> {
			return value.substring(0, 3);
		}).count();
		System.out.println("count = " + count);
	}
}