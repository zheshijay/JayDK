package algo.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LC0048rotate2darray {
	public void rotate(int[][] matrix) {
		int size = matrix.length;
		int[][] temp = new int[size][size];

		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				temp[col][size - row - 1] = matrix[row][col];
			}
		}
		System.arraycopy(temp, 0, matrix, 0, size);
	}
	
	
	public static void main(String[] args) {
		LC0048rotate2darray test = new LC0048rotate2darray();
		int[][] matrix = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		test.rotate(matrix);
		System.out.println(Arrays.deepToString(matrix));
		
	}
}
