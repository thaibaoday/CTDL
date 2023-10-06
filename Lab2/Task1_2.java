package Lab2;

public class Task1_2 {
	//get the nth value of the Fibonacci series	
	public static int getFibonancy(int n) {
		if (n <= 1) {
			return n;
		} else {
			return getFibonancy(n - 1) + getFibonancy(n - 2);
		}
	}
	// This method is used to display a Fibonaccci series based on
	//the parameter n. Ex. n=10 ==> 0 1 1 2 3 5 8 13 21 34
	public static void printFibonacci(int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(getFibonancy(i) + " ");
		}
	}

	public static void main(String[] args) {
		int n = 10;
		Task1_2.printFibonacci(n);
	}

}
