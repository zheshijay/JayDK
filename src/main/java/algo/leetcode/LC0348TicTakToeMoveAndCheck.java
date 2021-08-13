package algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC0348TicTakToeMoveAndCheck {

	char[][] board = null;

	/** Initialize your data structure here. */
	public LC0348TicTakToeMoveAndCheck(int n) {
		board = new char[n][n];
	}

	/**
	 * Player {player} makes a move at ({row}, {col}).
	 * 
	 * @param row    The row of the board.
	 * @param col    The column of the board.
	 * @param player The player, can be either 1 or 2.
	 * @return The current winning condition, can be either: 0: No one wins. 1:
	 *         Player 1 wins. 2: Player 2 wins.
	 */
	public int move(int row, int col, int player) {
		setValue(row, col, player);
		return getWinner(player);
	}

	private void setValue(int row, int col, int player) {
		board[row][col] = player == 1 ? 'X' : 'O';
	}

	private int getWinner(int player) {
		int size = board.length;
		char chess = player == 1 ? 'X' : 'O';
		
		int digLcount = 0;
		int digRcount = 0;
		for (int i = 0; i < size; i++) {
			
			int horCount = 0;
			int verCount = 0;
			
			for (int j = 0; j < size; j++) {
				// hor
				if (board[i][j] == chess)
					horCount++;
				if (horCount == size)
					return player;

				// ver
				if (board[j][i] == chess)
					verCount++;
				if (verCount == size)
					return player;

				// digr
				if (i == j && board[j][i] == chess) {
					digLcount++;
				}

				// digr
				if (i + j == size - 1 && board[j][i] == chess) {
					digRcount++;
				}
			}
		}
		
		if (digLcount == size || digRcount == size) {
			return player;
		}

		return 0;
	}

	
	private void printBoard() {
		System.out.println(Arrays.deepToString(board));
	}
	
	public static void main(String[] args) {
		LC0348TicTakToeMoveAndCheck ticTakToe = new LC0348TicTakToeMoveAndCheck(3);
		System.out.println(ticTakToe.move(0, 0, 1));
		ticTakToe.printBoard();
		
		System.out.println(ticTakToe.move(0, 2, 2));
		ticTakToe.printBoard();
		
		System.out.println(ticTakToe.move(2, 2, 1));
		ticTakToe.printBoard();
		
		System.out.println(ticTakToe.move(1, 1, 2));
		ticTakToe.printBoard();
		
		System.out.println(ticTakToe.move(2, 0, 1));
		ticTakToe.printBoard();
		
		System.out.println(ticTakToe.move(1, 0, 2));
		ticTakToe.printBoard();
		
		System.out.println(ticTakToe.move(2, 1, 1));
		ticTakToe.printBoard();
		
		
	}
}
