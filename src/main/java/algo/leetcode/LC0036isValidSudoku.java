package algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC0036isValidSudoku {
	private static final int L = 9;

	public static boolean isValidSudoku(char[][] board) {
		boolean[][] rows = new boolean[L][L];
		boolean[][] cols = new boolean[L][L];
		boolean[][] boxes = new boolean[L][L];

		for (int r = 0; r < L; ++r) {
			for (int c = 0; c < L; ++c) {
				if (board[r][c] != '.') {
					int value = board[r][c] - '1';
					int boxIndex = r / 3 * 3 + c / 3;
					if (rows[r][value] || cols[c][value] || boxes[boxIndex][value]) {
						return false;
					}
					rows[r][value] = true;
					cols[c][value] = true;
					boxes[boxIndex][value] = true;
					
					System.out.println("rows:" + Arrays.deepToString(rows));
				}
			}
		}
		return true;
	}

	// Driver code
	public static void main(String args[]) {
		char[][] board = new char[][] { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

		System.out.println(LC0036isValidSudoku.isValidSudoku(board));

	}
}
