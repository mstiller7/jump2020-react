package exceptions;

public class VotingAgeException extends Exception {
	
	private static final long serialVersionUID = 1842918759511093935L;
	public static final int MIN_AGE = 18;
	
	public VotingAgeException(int age) {
		
		super("Must be at least " + MIN_AGE + " years old to vote. You have to wait " + (MIN_AGE - age) + " years.");
		
	}

}
