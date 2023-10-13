package Lab4;

public class Task1_2 {
	// sort by descending order
	public static void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] < arr[j + 1]) {
                    // swap 
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
        }
    }

  public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {    
        int arr[] = { 1, 5, 10, 15, 20, 25 };
        Task1_2.bubbleSort(arr);
        System.out.println("Mảng sau khi sắp xếp:");
       Task1_2.printArray(arr);
    }


}
