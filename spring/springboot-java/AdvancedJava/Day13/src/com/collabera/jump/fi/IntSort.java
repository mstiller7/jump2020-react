package com.collabera.jump.fi;

import java.util.Comparator;

@FunctionalInterface
public interface IntSort {
	
	Integer[] sort(Integer[] array, Comparator<Integer> comparator);
	
}
