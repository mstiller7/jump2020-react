package com.collabera.jump;

public interface TestInterface {

	default void print() {
		System.out.println("Printing in Test Interface!");
	}
	
	static void printData() {
		System.out.println("Printing in Test Interface!");
	}
}
