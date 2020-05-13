package practice;

public class FizzBuzz {

	public static void main(String[] args) {
		
		// for all the numbers from 1-50...
		// if x is divisible by 3, print 'fizz'
		// if x is divisible by 5, print 'buzz'
		// if both, print 'fizzbuzz'
		
		for (int i = 1; i <= 50; i++) {
			
			System.out.println(i);
			
			if (i % 3 == 0) System.out.print("fizz");
			if (i % 5 == 0) System.out.print("buzz");
			
			System.out.println();
			
//			if (i % 3 == 0 && i % 5 == 0) {
//				System.out.println(i + ": fizzbuzz");
//			}			
//			else if (i % 3 == 0) {
//				System.out.println(i + ": fizz");
//			}
//			else if (i % 5 == 0) {
//				System.out.println(i + ": buzz");
//			}
			
		}

	}

}
