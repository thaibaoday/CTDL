package Lab5;

public class Task1_3 {
	public static void printMatrix(int M[][], int rowSize, int colSize) {
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++)
				System.out.print(M[i][j] + " ");

			System.out.println();
		}
	}
	// multiply 2 matrices
	public static int[][] multiply(int row1, int col1, int A[][], int row2, int col2, int B[][]) {
		int C[][] = new int[row1][col2];

		for (int i = 0; i < row1; i++) {
			for (int j = 0; j < col2; j++) {
				for (int k = 0; k < row2; k++)
					C[i][j] += A[i][k] * B[k][j];
			}
		}
		return C;

	}

	public static void main(String[] args) {
		int row1 = 3, col1 = 4, row2 = 4, col2 = 3;
		int A[][] = { { 1, 2, 3, 4 }, { 2, 3, 4, 5 }, { 3, 4, 5, 6 } };
		int B[][] = { { 1, 2, 3 }, { 2, 3, 4 }, { 3, 4, 5 }, { 4, 5, 6 } };
		System.out.println("Matrix A:");
		printMatrix(A, row1, col1);

		System.out.println("\nMatrix B:");
		printMatrix(B, row2, col2);

		int [][] C = multiply(row1, col1, A, row2, col2, B);
		System.out.println("\nResult Matrix:");
		printMatrix(C, row1, col2);
		
	}

}
