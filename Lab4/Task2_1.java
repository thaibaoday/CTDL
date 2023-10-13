package Lab4;

public class Task2_1 {
	// sort by descending order
	public static void mergeSort(int arr[], int l, int m, int r) {

		// Tìm kích thước của 2 mảng con để merged
		int n1 = m - l + 1;
		int n2 = r - m;

		// Tạo mảng tạm
		int L[] = new int[n1];
		int R[] = new int[n2];

		// Copy dữ liệu vào mảng tạm
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		// Merge các mảng tạm lại

		// Chỉ mục ban đầu của 2 mảng con
		int i = 0, j = 0;

		// Chỉ mục ban đầu của mảng phụ được hợp nhất
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] >= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		// Sao chép các phần tử còn lại của L[] nếu có
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		// Sao chép các phần tử còn lại của R[] nếu có
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	static void sort(int arr[], int left, int right) {
		if (left < right) {

			// Tìm điểm chính giữa
			int m = (left + right) / 2;

			// Hàm đệ quy tiếp tục chia đôi
			sort(arr, left, m);
			sort(arr, m + 1, right);

			mergeSort(arr, left, m, right);
		}
	}

	// In các phần tử của mảng
	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String args[]) {
		int arr[] = { 25, 30, 45, 6, 11, 90, 15 };

		System.out.println("Mảng ban đầu:");
		printArray(arr);

		Task2_1.sort(arr, 0, arr.length - 1);

		System.out.println("Mảng sau khi sắp xếp:");
		printArray(arr);
	}
}
