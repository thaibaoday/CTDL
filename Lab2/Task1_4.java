package Lab2;

public class Task1_4 {
	public static String moveTower(int n, String source, String dest, String spare) {
		if (n == 1)
			return "Take disk " + n + " move from " + source + " to " + spare;
		else {
			return moveTower(n - 1, source, dest, spare) + "\n" + "Take disk " + n + " move from " + source + " to "
					+ spare + "\n" + moveTower(n - 1, dest, spare, source);
		}
	}
	public static void main(String[] args) {
		System.out.println(moveTower(3, "A", "B", "C"));

	}



}
