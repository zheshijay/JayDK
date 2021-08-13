package algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC0329longestIncreasingPath {

	public int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	public int length, width;

	public int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		length = matrix.length;
		width = matrix[0].length;
		int[][] cache = new int[length][width];
		int ans = 0;
		for (int i = 0; i < length; ++i) {
			for (int j = 0; j < width; ++j) {
				ans = Math.max(ans, dfs(matrix, i, j, cache));
			}
		}
		
		System.out.println("cache:" + Arrays.deepToString(cache));
		return ans;
	}

	public int dfs(int[][] matrix, int x, int y, int[][] cache) {
		System.out.println("processing x:" + x + "|y:" + y + "|cache:" + cache[x][y]);
		if (cache[x][y] != 0) {
			return cache[x][y];
		}
		++cache[x][y];
		
		
		for (int[] dir : dirs) {
			int nx = x + dir[0], ny = y + dir[1];
			if (nx >= 0 && nx < length && ny >= 0 && ny < width
					&& matrix[x][y] < matrix[nx][ny]) {
				cache[x][y] = Math.max(cache[x][y], dfs(matrix, nx, ny, cache) + 1);
				System.out.println("[ processing x:" + x + "|y:" + y + "|cache:" + cache[x][y] + " ]");
			}
		}
		return cache[x][y];
	}
	
	public static void main(String[] args) {
		int[][] matrix = new int[][] {
			{9,9,4},
			{6,6,8},
			{2,1,1}
		};
		
		LC0329longestIncreasingPath test = new LC0329longestIncreasingPath();
		int res = test.longestIncreasingPath(matrix);
		System.out.println("res:" + res);
		
	}

}
