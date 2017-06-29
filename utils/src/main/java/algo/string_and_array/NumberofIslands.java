package algo.string_and_array;

import algo.utils.PrintUtils;

public class NumberofIslands {

	
	public int numIslands(int[][] mat) {
		int count = 0;
		
		for (int i = 0; i < mat.length; i++){
			for (int j = 0; j < mat[i].length; j++)
				if (mat[i][j] == 1) {
					dfs(mat, i, j);
					++count;
					
					System.out.println("-----------------------------");
					
					PrintUtils.printTwoDArray(mat);
				}
		}    
		return count;
	}

	private void dfs(int[][] mat, int i, int j) {
		if (i < 0 || j < 0 || i >= mat.length || j >= mat[i].length || mat[i][j] == 0) return;
		
		mat[i][j] = 0;
		dfs(mat, i + 1, j);
		dfs(mat, i - 1, j);
		dfs(mat, i, j + 1);
		dfs(mat, i, j - 1);
	}
	
	    
	public static void main(String[] args){

		NumberofIslands test = new NumberofIslands();

		int[][] mat = new int[][]{
			{1, 1, 0, 0, 0},
			{1, 1, 0, 0, 0},
			{0, 0, 1, 0, 0},
			{0, 0, 0, 1, 1}}
		;

			System.out.println(test.numIslands(mat));
	}
}
