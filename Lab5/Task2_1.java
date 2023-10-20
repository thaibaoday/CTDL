package Lab5;

public class Task2_1 {		
	static char[][] board = { { 'X', 'O', 'X' }, { 'O', 'X', 'O' }, { 'O', ' ', 'X' } };
		
		/*
		 * Task
		 * This method checks all rows and returns true if any of them are marked with
		 * all of a single player's markers. Otherwise, returns false.
		 */
		static  boolean checkRows() {
			for (int i = 0; i < 3; i++) {
				if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
					return true;
				}
			}
			return false;
		}
		public static void main(String[] args) {
			System.out.println(checkRows());
		}

}
