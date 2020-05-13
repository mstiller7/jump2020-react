package com.collabera.jump;

public class TestClass implements TestInterface{

	public TestClass() {
		this.print();
	}
	
	@Override
	public void print() {
		
		
		System.out.println("This is a print from TestClass");
	}
	
	public static void main(String[] args) {
		TestInterface.printData();
		
		new TestClass();
	}
	
}
