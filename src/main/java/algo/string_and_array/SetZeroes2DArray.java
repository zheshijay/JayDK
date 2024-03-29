package algo.string_and_array;

import java.util.HashSet;
import java.util.Set;

public class SetZeroes2DArray {
	/*
给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。

示例 1:

输入: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
输出: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
示例 2:

输入: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
输出: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
进阶:

一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
你能想出一个常数空间的解决方案吗？
	 */
	public void setZeroes(int[][] matrix) {
	    int R = matrix.length;
	    int C = matrix[0].length;
	    Set<Integer> rows = new HashSet<Integer>();
	    Set<Integer> cols = new HashSet<Integer>();

	    // Essentially, we mark the rows and columns that are to be made zero
	    for (int i = 0; i < R; i++) {
	      for (int j = 0; j < C; j++) {
	        if (matrix[i][j] == 0) {
	          rows.add(i);
	          cols.add(j);
	        }
	      }
	    }

	    // Iterate over the array once again and using the rows and cols sets, update the elements.
	    for (int i = 0; i < R; i++) {
	      for (int j = 0; j < C; j++) {
	        if (rows.contains(i) || cols.contains(j)) {
	          matrix[i][j] = 0;
	        }
	      }
	    }
	  }

	public static void main(String args[]){
		
		SetZeroes2DArray test = new SetZeroes2DArray();
		
		int[][] matrix = new int[3][3];
		
		matrix[0][0] = 1;
		matrix[0][1] = 1;
		matrix[0][2] = 1;
		
		matrix[1][0] = 1;
		matrix[1][1] = 0;
		matrix[1][2] = 1;
		
		matrix[2][0] = 1;
		matrix[2][1] = 1;
		matrix[2][2] = 1;
		
		System.out.println("---------- before -----------");
		test.printMatrix(matrix);
		
		System.out.println("---------- after -----------");
		
		test.setZeroes(matrix);
		
		test.printMatrix(matrix);
		
		
		
	}
}
