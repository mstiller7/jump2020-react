package com.collabera.jump.fi;

import java.util.Arrays;

public class MainClass {

	public static void main(String[] args) {

		/*
		 * CalcInterface impl = new CalcImpl();
		 * 
		 * System.out.println(impl.add(5, 3));
		 * 
		 * System.out.println(impl.mul(5, 3));
		 * 
		 * System.out.println(impl instanceof CalcInterface);
		 * 
		 * System.out.println(impl instanceof CalcImpl);
		 * 
		 * System.out.println(impl instanceof MathOperation);
		 */

//		MathOperation add = (n) -> {
//			int a = 0;
//			for (int i = 0; i < n.length; i++) {
//				a += n[i];
//			}
//			return a;
//		};

		 MathOperation sqr = (a, b) ->  (int)Math.pow((int)(a * b), 2) ;
		 
		 MathOperation div = (a, b) -> a / b ;
		 
		 MathOperation mod = (a, b) -> a % b ;

		
		System.out.println(sqr.operation(5,5));
		System.out.println(sqr.operation(15,15));
		System.out.println(div.operation(5,5));
		System.out.println(mod.operation(5,5));
		
		
		SortOp ascend = (a) -> {
			Arrays.sort(a);
			return a;
		};
		
		int[] x= {1,5,100,50};
		
		System.out.println(Arrays.toString(ascend.sort(x)));

		// System.out.println(mul.operation(5, 4));

	}

}
