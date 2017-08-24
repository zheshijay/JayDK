package algo.binary_search;

import java.util.Arrays;

/**
 * 
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.

For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]

 * 
 * @author ZShi
 *
 */
public class SearchMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix.length ==0) return false;
		
		//Step1: Find the target row
		int start = 0, end = matrix.length-1;
		while(start+1<end){
			int mid = (start+end)/2;
			if(target >= matrix[mid][0]) start = mid;
			else end = mid;
		}
	
		int newStart = 0, newEnd = matrix[0].length-1;
		int targetRow = matrix[start][0]<=target?start:end;
		
		//Step2: Find the target
		while(newStart+1<newEnd){
			int mid = (newStart+newEnd)/2;
			if(target > matrix[targetRow][mid]) {
				newStart = mid;
			}else if(target < matrix[targetRow][mid])
				newEnd = mid;
			else{
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args){
		SearchMatrix test = new SearchMatrix();
		int[][] matrix = new int[3][4];
		matrix[0][0] = 1; 	matrix[0][1] = 3; 	matrix[0][2] = 5;   matrix[0][3] = 7;
		matrix[1][0] = 10;	matrix[1][1] = 11;	matrix[1][2] = 16;   matrix[1][3] = 20;
		matrix[2][0] = 23;	matrix[2][1] = 30;	matrix[2][2] = 34;   matrix[2][3] = 50;
		
		System.out.println(Arrays.deepToString(matrix));
		
		int target = 52;
		System.out.println(test.searchMatrix(matrix, target));
		
	}
}
