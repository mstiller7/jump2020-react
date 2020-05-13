package com.collabera.jump.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PrintNamesInRerverseOrder {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		
		
		for(int i =0 ; i< 500000;i++)
		{
			list.add("name" + Math.random());
		}
		
		long startTime = System.currentTimeMillis();
		list.stream()
		.sorted(Comparator.reverseOrder())
		.forEach(System.out::println);
		
		System.out.println(System.currentTimeMillis() - startTime);
		System.out.println(list.get(list.size()-1));
		
		startTime = System.currentTimeMillis();
		//List.of( "john", "Peter", "peter", "Peter", "Peter", "Peter", "Amazon","Raj","12345")
		list.parallelStream()
		.sorted(Comparator.reverseOrder());
		
		System.out.println(list.get(list.size()-1));
		//.forEach(System.out::println);
		
		System.out.println(System.currentTimeMillis() - startTime);
		
	}
}
