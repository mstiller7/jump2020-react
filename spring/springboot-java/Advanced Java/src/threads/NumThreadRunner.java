package threads;

import java.util.stream.IntStream;

public class NumThreadRunner {
	
	public static void main(String[] args) {
		
		System.out.println("Main Thread ID: " + Thread.currentThread().getId());
		
		for (int i = 0; i < 3; i++) {
			
			new NumThread().start();
			
		}
		
		IntStream.range(0, 3).forEach($ -> {
			System.out.println("Printing once.");
		});
		
	}

}
