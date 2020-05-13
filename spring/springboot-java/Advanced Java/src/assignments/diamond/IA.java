package assignments.diamond;

public interface IA {

	default void printIA(String data) {
		System.out.println("Printing in IA " + reverse(data));
	}

	private String reverse(String data) {
		return new StringBuilder(data).reverse().toString();
	}
}
