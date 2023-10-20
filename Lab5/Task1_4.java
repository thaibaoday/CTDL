package Lab5;

public class Task1_4 {	   
	// tranpose a matrix
	public static int[][] transpose(int[][] a,int column, int row) {	
        int[][] transpose = new int[column][row];
        for(int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                transpose[j][i] = a[i][j];
            }
        }
		return transpose;
        }
 
    public static void printMatrix(int[][] matrix) {
        for(int[] row : matrix) {
            for (int column : row) {
                System.out.print(column + "    ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {   
    	int row = 2, column = 3;
        int[][] matrix = { {2, 3, 4}, {5, 6, 4} };          
        System.out.println("Matrix:");
        printMatrix(matrix);
        System.out.println("\nResult Matrix:");
        printMatrix(transpose(matrix, column, row));
    }
        
}