import model.Customer;

import java.util.ArrayList;

public class Controller {
	
	private final ArrayList<Customer> customers = new ArrayList<>();
	private Customer customer;
	
	//	Called once at program load.
	//	Perform any setup tasks.
	public void init() {
		customers.add(new Customer("test", "test"));
		landing();
	}
	
	public void landing() {
		
		View.splashLanding();
		
		switch (View.getInt("Enter choice (1 or 2):")) {
			case 1 -> register();
			case 2 -> login();
			default -> {
				View.alert("Error. Please retry.");
				landing();
			}
		}
		
	}
	
	public void register() {
		
		View.splashRegister();
		
		String username = View.getString("Enter username:");
		String password = View.getString("Enter password:");
		customer = new Customer(username, password);
		customers.add(customer);
		
		menu();
		
	}
	
	public void login() {
	
	}
	
	public void menu() {
	
	}
	
	public void order() {
	
	}
	
	public void replace() {
	
	}
	
	/*
	 * register
	 * login
	 *
	 * menu options:
	 * make order
	 * make replacement
	 */
	
}
