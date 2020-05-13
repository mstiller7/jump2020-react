package practice.arrays;

public class TwoDArrays {

	public static void main(String[] args) {
		
		// a 1-dimensional array.
		int[] gridLinear = {
				1, 2, 3,
				4, 5, 6,
				7, 8, 9
		};
		
		System.out.println("5: " + gridLinear[4]);
		
		// a 2-dimensional array.
		int[][] grid2D = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		
		System.out.println("5: " + grid2D[1][1]);
		
		// iterate through the 2D-array to print the values.
		for (int[] i : grid2D) {
			for (int j : i) {
				System.out.println(j);
			}
		}
		
		// how deep does it go...?
//		int[][][] threes = {
//				{
//					{1, 2, 3}
//				}
//		};

	}

}
