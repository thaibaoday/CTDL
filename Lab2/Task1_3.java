package Lab2;

public class Task1_3 {
	    public static void printPascalTriangle(int n) {
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j <= i; j++) {
	                System.out.print(getPascalValue(i, j) + " ");
	            }
	            System.out.println();
	        }
	    }

	    public static int getPascalValue(int i, int j) {
	        if (j == 0 || j == i) {
	            return 1;
	        } else {
	            return getPascalValue(i - 1, j - 1) + getPascalValue(i - 1, j);
	        }
	    }

	    public static void main(String[] args) {
	        printPascalTriangle(5);
	    }
	
}
