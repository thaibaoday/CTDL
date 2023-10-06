package Lab3;

public class Task1_3 {
//How to change the implemented methods so that they can be used for the
//case in which the array is sorted by descending order
	public static int linearSearch(int[] array, int target) {
		for (int i = array.length - 1; i >= 0; i--) {
			if (array[i] == target) {
				return i;
			}
		}
		return -1;
	}

	public static int binarySearch(int[] array, int target, int low, int high) {
		if (high >= low) {
			int mid = ( high + low) / 2;
			if (array[mid] == target) {
				return mid;
			}
			if (array[mid] < target) {
				return binarySearch(array, target, low, mid - 1);
			}
			return binarySearch(array, target, mid + 1, high);
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] array = { 99, 45, 45, 12, 10, 10, 10, 2 };
		int target = 15;
		System.out.println(linearSearch(array, target));
		System.out.println(binarySearch(array, target, 0, array.length - 1));
	}
}
