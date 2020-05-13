package com.collabera.jump.fi;

@FunctionalInterface
public interface GenericMathOperation<E> {
	E operation(E a, E b);
}
