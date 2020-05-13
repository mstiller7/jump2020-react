package exceptions;

public class OverdraftException extends Exception {

	private static final long serialVersionUID = -5387217207436482562L;
	
	
	public OverdraftException(int amount, int balance) {
		
		super("You tried to withdraw " + amount + ", but your account only has " + balance + ".");
		
	}
	

}
