package Lab5;

public class Task2_3 {
	static char[][] board = { { 'X', 'O', 'X' }, { 'O', 'X', 'O' }, { 'O', 'X', 'X' } };

	/*
	 * This method checks both diagonals and returns true if any of them are marked
	 * with all of a single player's markers. Otherwise, returns false.
	 */
	static boolean checkDiagonals() {
		if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
			return true;
		}
		if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(checkDiagonals());
	}

}
