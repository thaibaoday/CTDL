package Lab1;

import java.util.Arrays;

public class MyArray {
	public static void main(String[] args) {
		System.out.println("Task 1.1");
		int[] input1 = { 1, 2, 3 };
		System.out.println(Arrays.toString(mirror(input1)));

		int[] input2 = { 1, 3, 5, 1, 3, 7, 9, 8 };
		System.out.println(Arrays.toString(removeDuplicates(input2)));

		System.out.println("Task 1.2");
		int[] input3 = { 10, 11, 12, 13, 14, 16, 17, 19, 20 };
		getMissingValues(input3);

		int[] input4 = { 10, 11, 12, -1, 14, 10, 17, 19, 20 };
		int k = 3;
		fillMissingValues(input4, k);
		for (int i : input4) {
			System.out.print(i + " ");
		}
	}

//Method mirror that outputs the contents of an array in a reverse order like a mirror.
	public static int[] mirror(int[] arr) {
		int[] result = new int[arr.length * 2];
		for (int i = 0; i < arr.length; i++) {
			result[i] = arr[i];
			result[result.length - i - 1] = arr[i];
		}
		return result;
	}
//Removes all duplicate elements from an array and returns a new array.

	public static int[] removeDuplicates(int[] arr) {
		boolean[] appeared = new boolean[100];
		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			if (!appeared[arr[i]]) {
				appeared[arr[i]] = true;
				count++;
			}
		}
		int[] output = new int[count];
		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			if (appeared[arr[i]]) {
				output[j++] = arr[i];
				appeared[arr[i]] = false;
			}
		}

		return output;
	}

// Find missing integers in a sorted array.
	public static void getMissingValues(int[] arr) {
		int j = 0;
		for (int i = arr[0]; i <= arr[arr.length - 1]; i++) {
			if (j < arr.length && i == arr[j]) {
				j++;
			} else {
				System.out.println(i + " ");
			}
		}
	}

//Fill in negative or repeated integers with the average of k, preceding and adjacent integers.
	public static void fillMissingValues(int[] arr, int k) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0 || (i > 0 && arr[i] == arr[i - 1]) || (i < arr.length - 1 && arr[i] == arr[i + 1])) {
				int sum = 0;
				int count = 0;
				for (int j = Math.max(0, i - k); j <= Math.min(arr.length - 1, i + k); j++) {
					if (j != i) {
						sum += arr[j];
						count++;

					}
				}
				arr[i] = sum / count;
			}
		}
	}
}
