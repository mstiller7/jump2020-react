
public class CalcMain {

	public static void main(String[] args) {
		
		Calculator<Integer> add = (a,b) ->  a+b;
		
		Calculator<Double> addDouble = (a,b) ->  a+b;
		
		Calculator<Double> mulDouble = (a,b) ->  a*b;
		
		System.out.println(add.operation(4, 5));
		
		System.out.println(addDouble.operation(4.34, 5.86));
		
		
	}
}
