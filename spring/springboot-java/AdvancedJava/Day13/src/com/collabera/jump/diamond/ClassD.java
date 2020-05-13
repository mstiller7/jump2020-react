package com.collabera.jump.diamond;

public class ClassD implements IB, IC {

	@Override
	public void printIB() {
		// TODO Auto-generated method stub

	}

	@Override
	public void printIC() {
		// TODO Auto-generated method stub

	}
	
	protected String reverse(String data) {
		return new StringBuilder(data).reverse().toString();
	}

	@Override
	public void printIA(String data) {
		// TODO Auto-generated method stub
		IB.super.printIA(data);
		IC.super.printIA(data);
	}

	public static void main(String[] args) {
		ClassD classD = new ClassD();
		classD.printIA("TestNew");
	}

}
