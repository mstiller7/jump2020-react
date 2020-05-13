package exceptions;

public class CheckedExceptions {

	public static void checked() throws Exception {
		throw new Exception("this is a checked exception");
	}

	public static void unchecked() {
		throw new RuntimeException("an unchecked exception");
	}

	public static void main(String[] args) {

		try {
			checked();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		unchecked();
		
		System.out.println("will this print?");
		
	}

}
