package Lab2;

public class Task2_1 {
	//This method takes as an input one integer value n and then output on console a pyramid as on figure below for example for n=4: 
	    public static void main(String[] args) {
	        drawPyramid(4);
	    }

	    public static void drawPyramid(int n) {
	        drawPyramidHelper(n, 0);
	    }

	    private static void drawPyramidHelper(int n, int i) {
	        if (n > 0) {
	            drawPyramidHelper(n - 1, i + 1);
	            printStars(2 * n - 1, i);
	        }
	    }

	    private static void printStars(int n, int i) {
	        for (int j = 0; j < i; j++) {
	            System.out.print(" ");
	        }
	        for (int j = 0; j < n; j++) {
	            System.out.print("*");
	        }
	        System.out.println();
	    }

}
