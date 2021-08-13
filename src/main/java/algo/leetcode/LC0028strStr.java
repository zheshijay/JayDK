package algo.leetcode;

import java.util.Arrays;

public class LC0028strStr {

	public void rotate(int[][] matrix) {
		int n = matrix.length;

		// transpose matrix
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				
				System.out.println("swap: " + matrix[i][j] + " and " + matrix[j][i]);
				
				int tmp = matrix[j][i];
				matrix[j][i] = matrix[i][j];
				matrix[i][j] = tmp;
			}
		}
		// reverse each row
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n / 2; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[i][n - j - 1];
				matrix[i][n - j - 1] = tmp;
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] {
			{1,2,3},
			{4,5,6},
			{7,8,9}
		};
		LC0028strStr test = new LC0028strStr();
		test.rotate(matrix);
		
		System.out.println(Arrays.deepToString(matrix));
	}
}
