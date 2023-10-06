package Lab3;

public class Task1_1 {
	// To find the index of the target in the array. If the target
	// is not found in the array, then the method returns -1.
	// Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}, 45
	// Output: 3
	public static int iterativeLinearSearch(int[] array, int target) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == target) {
				return i;
			}
		}
		return -1;
	}

	// To find the index of the target in the array. If the target
	// is not found in the array, then the method returns -1.
	// Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}, 15
	// Output: -1
	public static int recursiveLinearSearch(int[] array, int target, int i) {
		if (i >= array.length) {
			return -1;
		}
		if (array[i] == target) {
			return i;
		}
		return recursiveLinearSearch(array, target, i + 1);
	}

	public static void main(String[] args) {
		int[] array = { 12, 10, 9, 45, 2, 10, 10, 45 };
		int target1 = 45;
		System.out.println(iterativeLinearSearch(array, target1));
		int target2 = 15;
		System.out.println(recursiveLinearSearch(array, target2, 0));
	}
}
