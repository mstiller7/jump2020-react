package com.collabera.jump.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForEachClass {

	public static void main(String[] args) {

		List<String> names = Arrays.asList("name3", "name2", "name1");

		//names.add("New Name");
		List<String> namesList = List.of("name3", "name2", "name1");
		names.forEach(System.out::println);
		
		String[] namesArr = { "1" , "2" ,"3"};
		List<String> finalList = new ArrayList<String>();
		
		Arrays.stream(namesArr).forEach(finalList::add);
		
		
		
	//	names.stream().anyMatch(Character.i)

	}

}
