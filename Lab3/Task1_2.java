package Lab3;

public class Task1_2 {
	// To find the index of the target in the sorted array. If the
	//target is not found in the array, then the method returns -1.

	
	public static int iterativeBinarySearch(int[] array, int target, int low, int high) {
		high = array.length - 1;
		while (high >= low) {
			int mid = (high + low) / 2;
			if (array[mid] == target) {
				return mid;
			} else if (array[mid] > target) {
				high = mid - 1;
			} else
				low = mid + 1;
		}
		return -1;
	}

	public static int recursiveBinarySearch(int[] array, int target, int low, int high) {
		low = 0;
		high = array.length - 1;
		if (high >= low) {
			int mid = (high + low) / 2;
			if (array[mid] == target) {
				return mid;
			} else if (array[mid] > target) {
				recursiveBinarySearch(array, target, low, mid - 1);
				recursiveBinarySearch(array, target, mid + 1, high);
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] array = { 2, 10, 10, 10, 12, 45, 45, 99 };
		int target = 15;
		System.out.println(iterativeBinarySearch(array, target, 0, array.length - 1));
		System.out.println(recursiveBinarySearch(array, target, 0, array.length - 1));
	}
}
