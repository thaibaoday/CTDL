package Lab4;

import java.util.Random;

public class Task2_2 {
	private static Random random = new Random();

	// sort by ascending order
	private static void quickSort(int[] array, int left, int right, String pivotType) {
		if (left < right) {
			int pivotIndex;
			switch (pivotType) {
			case "first":
				pivotIndex = getPivot_First(left, right);
				break;
			case "last":
				pivotIndex = getPivot_Last(left, right);
				break;
			case "random":
				pivotIndex = getPivot_Random(left, right);
				break;
			case "meanOfThree":
				pivotIndex = getPivot_MedianOfThree(left, right);
				break;
			default:
				throw new IllegalArgumentException("Invalid pivot type passed");
			}
			swap(array, pivotIndex, right);
			int storeIndex = left;
			for (int i = left; i < right; i++) {
				if (array[i] < array[right]) {
					swap(array, i, storeIndex);
					storeIndex++;
				}
			}
			swap(array, storeIndex, right);
			quickSort(array, left, storeIndex - 1, pivotType);
			quickSort(array, storeIndex + 1, right, pivotType);
		}
	}

	// select pivot element based on the median of three strategy
	private static int getPivot_MedianOfThree(int left, int right) {
		int mid = left + (right - left) / 2;
		if ((left < mid && mid < right) || (right < mid && mid < left)) {
			return mid;
		} else if ((mid < left && left < right) || (right < left && left < mid)) {
			return left;
		} else {
			return right;
		}
	}

	// select pivot element based on the first element in the array
	private static int getPivot_First(int low, int high) {
		return low;
	}

    // select pivot element based on the last element in the array
	private static int getPivot_Last(int low, int high) {
		return high;
	}

	// select pivot element based on choosing a randomly element in the array
	private static int getPivot_Random(int low, int high) {
		return random.nextInt((high - low) + 1) + low;
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		int[] array = { 1, 3, 2, 5, 7, 6, 9 };
		System.out.println("Mảng sau khi sắp xếp: ");
		quickSort(array, 0, array.length - 1, "meanOfThree");
		for (int item : array) {
			System.out.print(item + " ");
		}
	}

}
