package com.collabera.jump.diamond;

public interface IC extends IA{
	void printIC();
	
	@Override
	default void printIA(String data) {
		// TODO Auto-generated method stub
		IA.super.printIA(data);
	}
}
