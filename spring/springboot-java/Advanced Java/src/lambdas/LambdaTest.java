package lambdas;

public class LambdaTest {
	public static void main(String args[]) {
				
		LambdaTest tester = new LambdaTest(); // with type declaration
		MathOperation<Integer> addition = Integer::sum;
//		MathOperation<Integer> addition = (Integer a, Integer b) -> a + b; // with out type declaration
		MathOperation<Integer> subtraction = (a, b) -> a - b; // with return statement along with curly braces

		MathOperation<Integer> multiplication = (a, b) -> {
			return a * b;
		}; // without return statement and without curly braces
		MathOperation<Integer> division = (a, b) -> a / b;

		MathOperation<Double> divisionDouble = (a, b) -> a / b;
		System.out.println(divisionDouble.operation(10.5, 3.0));

		System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
		System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
		System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
		System.out.println("10 / 5 = " + tester.operate(10, 5, division));
	}

	private int operate(int a, int b, MathOperation<Integer> mathOperation) {
		return mathOperation.operation(a, b);
	}
}