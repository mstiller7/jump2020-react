package exercises;

import java.util.Arrays;

public class ShiftArray {

	public static void main(String[] args) {

		// create an array that shifts an array "left" by a number n.

		int[] one = { 1, 2, 3 };
		shiftHelper(one, shiftLeft(one, 1));

		int[] two = { 1, 2, 3, 4 };
		shiftHelper(two, shiftLeft(two, 3));

	}

	public static int[] shiftLeft(int[] arr, int n) {

		// option 1: go through the first array and construct a second array
		// reduce the indices of all values by n, and when the new index would be below
		// 0,
		// subtract that number from the length of the original array; that is its new
		// index

		int size = arr.length;

		int[] shifted = new int[size];

		for (int i = 0; i < arr.length; i++) {

			int newIndex = i - n;

			if (newIndex < 0) {
				newIndex = size + newIndex;
			}

			shifted[newIndex] = arr[i];

		}

		return shifted;

	}

	public static void shiftHelper(int[] orig, int[] arr) {

		System.out.println(
				"The original array, " + Arrays.toString(orig) + ", has now become: " + Arrays.toString(arr) + ".");

	}

}
