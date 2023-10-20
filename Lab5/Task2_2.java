package Lab5;

public class Task2_2 {
	static char[][] board = { { 'X', 'O', 'X' }, { 'O', 'X', 'O' }, { 'O', ' ', 'X' } };
	
	/*
	 * This method checks all columns and returns true if any of them are marked
	 * with all of a single player's. Otherwise, returns false.
	 */

	 static boolean checkColumns() {
		for (int i = 0; i < 3; i++) {
			if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		System.out.println(checkColumns());
	}

}
