package net.mstiller.dollars.app;

import net.mstiller.dollars.controller.DollarsBankController;

public class DollarsBankApplication {
	
	private static DollarsBankController controller;
	
	public static void main(String[] args) {
		
		controller = new DollarsBankController();
		controller.init();
		
	}
	
}
