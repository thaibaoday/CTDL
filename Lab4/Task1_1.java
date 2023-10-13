package Lab4;

public class Task1_1 {
	// sort by descending order
	public static void selectionSort(int arr[])   { 
        int n = arr.length; 
       
        for (int i = 0; i < n - 1; i++) {            
            int min_idx = i; 
            for (int j = i + 1; j < n; j++) { 
                if (arr[j] > arr[min_idx]) 
                    min_idx = j; 
            }         
            int temp = arr[min_idx]; 
            arr[min_idx] = arr[i]; 
            arr[i] = temp; 
        } 
    } 
  
   public static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
  
    public static void main(String args[])  {  
        int arr[] = { 55, 33, 44, 22, 11 };  
        Task1_1.selectionSort(arr);
        System.out.println("Mảng đã sắp xếp: "); 
        Task1_1.printArray(arr);
    } 


}
