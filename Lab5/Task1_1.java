package Lab5;

public class Task1_1 {
	public static void printMatrix(int M[][], int rowSize, int colSize) {
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++)
				System.out.print(M[i][j] + " ");

			System.out.println();
		}
	}
	// add 2 matrices
	public static int[][] add(int A[][], int B[][], int size) {	
		int C[][] = new int[size][size];

		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				C[i][j] = A[i][j] + B[i][j];

		return C;
	}


	public static void main(String[] args) {	
		int size = 2;
		int A[][] = {{7, 2}, {5, 3}};

		System.out.println("Matrix A:");
		printMatrix(A, size, size);

		int B[][] = {{2, 1}, {3, 1}};

		System.out.println("\nMatrix B:");
		printMatrix(B, size, size);

		int C[][] = add(A, B, size);

		System.out.println("\nResult Matrix:");
		printMatrix(C, size, size);
	}

}
