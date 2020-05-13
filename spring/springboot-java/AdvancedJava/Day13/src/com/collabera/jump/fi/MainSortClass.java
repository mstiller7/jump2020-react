package com.collabera.jump.fi;

import java.util.Arrays;
import java.util.Comparator;

public class MainSortClass {

	public static void main(String[] args) {

		Comparator<Integer> reverseComparator = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}

		};

		Comparator<Integer> forwardComparator = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1 - o2;
			}

		};
		
		


//		IntSort sorter = (a, b) -> {
//
//			Arrays.sort(a, b);
//
//			return a;
//		};
//		
		GSort<Integer> sorter1 = (a, b) -> {

			Arrays.sort(a, b);

			return a;
		};

		Integer[] array = { 500, 200, 02, 10, 340, 2 };

		
		GSort<String> sorterString = (a, b) -> {

			Arrays.sort(a, b);

			return a;
		};

		String[] name = { "Hi", "raj", "this", "is", "lambda", "fucntions" };
//		System.out.println(Arrays.toString(sorter.sort(array, reverseComparator)));
//
//		System.out.println(Arrays.toString(sorter.sort(array, forwardComparator)));

		System.out.println(Arrays.toString(sorter1.sort(array, forwardComparator)));

		System.out.println(Arrays.toString(sorterString.sort(name,null)));

	}

}
