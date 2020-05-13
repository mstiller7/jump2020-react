package com.collabera.jump.fi;

import java.util.Comparator;

@FunctionalInterface
public interface GSort<E> {
	
	E[] sort(E[] array, Comparator<E> comparator);
	
}
