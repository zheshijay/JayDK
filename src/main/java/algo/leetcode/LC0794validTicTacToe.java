package algo.leetcode;

public class LC0794validTicTacToe {

	public boolean validTicTacToe(String[] b) {
		int size = b.length;
		// total count of x and 0
		int xCount = 0, oCount = 0;

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (b[i].charAt(j) == 'X')
					xCount++;
				if (b[i].charAt(j) == 'O')
					oCount++;
			}
		}
		
		if (oCount != xCount && oCount != xCount - 1) {
			return false;
		}

		// xCount has 1 more cheese than oCount if win
		if (win(b, 'X') && (xCount - oCount != 1)) {
			return false;
		}

		// xCount has 1 more cheese than oCount if win
		if (win(b, 'O') && (xCount != oCount)) {
			return false;
		}

		return true;
	}

	boolean win(String[] b, char p) {
		int size = b.length;

		int diaCount = 0;
		int dia2Count = 0;
		for (int x = 0; x < 3; x++) {
			int rowCount = 0;
			int colCount = 0;

			for (int y = 0; y < size; y++) {
				System.out.println("Checking x:" + x + "|y:" + y);
				// row
				if (b[x].charAt(y) == p)
					rowCount++;

				// col
				if (b[y].charAt(x) == p)
					colCount++;

				// dig
				if (x == y && b[x].charAt(y) == p)
					diaCount++;

				// dig2
				if ((x + y == (size - 1)) && b[x].charAt(y) == p)
					dia2Count++;
			}

			if (rowCount == size || colCount == size) {
				return true;
			}
		}

		if (diaCount == size || dia2Count == size) {
			return true;
		}

		return false;
	}

	public boolean hasCheckerWon(String[] b, char c) {
		for (int i = 0; i < b.length; ++i) {
			if (b[i].charAt(0) == c && b[i].charAt(1) == c && b[i].charAt(2) == c) {
				// 如果一整行都是 c
				return true;
			}
			if (b[0].charAt(i) == c && b[1].charAt(i) == c && b[2].charAt(i) == c) {
				// 如果一整列都是 c
				return true;
			}
		}

		if (b[0].charAt(0) == c && b[1].charAt(1) == c && b[2].charAt(2) == c) {
			// 如果正对角线都是 c
			return true;
		}
		if (b[0].charAt(2) == c && b[1].charAt(1) == c && b[2].charAt(0) == c) {
			// 如果反对角线都是 c
			return true;
		}

		return false;
	}
	
	
	
	//---- test
	
	
	public boolean validTicTacToe2(String[] grid) {
		int len = grid.length, wid = grid[0].length();
		int xCnt = 0, oCnt = 0;
		                                
		for(int i =0; i< len; i++) {
			for(int j=0; j< wid; j++) {
				if (grid[i].charAt(j) == 'O') {
					oCnt++;
				}
				
				if (grid[i].charAt(j) == 'X') {
					xCnt++;
				}
			}
		}
		
		if (oCnt != xCnt && oCnt != xCnt - 1) {
			return false;
		}
		
		if (isWin(grid, 'X') && xCnt - oCnt != 1) {
			return false;
		}
		
		if (isWin(grid, 'O') && xCnt != oCnt) {
			return false;
		}
		
		return true;
	}
	
	boolean isWin(String[] grid, char c) {
//		int len = grid.length, wid = grid[0].length();
		
		int size = grid.length;
		int  diaCnt = 0, diaCnt2 = 0;
		for(int i =0; i< size; i++) {
			int rowCount = 0;
			int colCount = 0;
	
			for(int j=0; j< size; j++) {
				if (grid[i].charAt(j) == c) {
					rowCount++;
				}
				
				if (grid[j].charAt(i) == c) {
					colCount++;
				}
				
				if (i == j && grid[i].charAt(j) == c) {
					diaCnt++;
				}
				
				if (i + j == (size -1) && grid[i].charAt(j) == c) {
					diaCnt2++;
				}
			}
			
			if (rowCount == size || colCount == size) {
				return true;
			}
		}
		
		if (diaCnt == size || diaCnt2 == size) {
			return true;
		}

		return false;
		
	}
	
	
	
	
	public static void main(String[] args) {
		String[] board = new String[] {
				"XO ",
				"XXX",
				"O O"};
		
		LC0794validTicTacToe test = new LC0794validTicTacToe();
		boolean ans = test.validTicTacToe(board);
		System.out.println("ans:" + ans);
		
//		boolean res2 = test.validTicTacToe2(board);
//		System.out.println("res2:" + res2);
		
		
	}

}
