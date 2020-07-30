package net.mstiller.dollars.app;

import net.mstiller.dollars.controller.DollarsBankController;

public class DollarsBankApplication {
	
	public static void main(String[] args) {
		
		DollarsBankController controller = new DollarsBankController();
		controller.init();
		
	}
	
}
