package algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC0378kthSmallest {
	public int kthSmallest(int[][] matrix, int k) {
		int row = matrix.length;
		int col = matrix[0].length;

		System.out.println("row:" + row + "|col:" + col);
		int left = matrix[0][0];
		int right = matrix[row - 1][col - 1];
		
		System.out.println("left:" + left + "|right:" + right);
		
		while (left < right) {
			
			System.out.println("left:"+left+"|right:"+right);
			
			// 每次循环都保证第K小的数在start~end之间，当start==end，第k小的数就是start
			int mid = (left + right) / 2;
			System.out.println("mid:" + mid);
			
			// 找二维矩阵中<=mid的元素总个数
			int count = findSmallerOrEqualsToMid(matrix, mid);
			System.out.println("---- Found " + count + " smaller than " + mid);
			
			if (count < k) {
				// 第k小的数在右半部分，且不包含mid
				left = mid + 1;
			} else {
				// 第k小的数在左半部分，可能包含mid
				right = mid;
			}
		}
		return left;
	}

	private int findSmallerOrEqualsToMid(int[][] matrix, int mid) {

		// 从第一行最后一个找
		// (1) 如果mid大于最后一个，就加上这一行所有元素的count = (col + 1),然后跳到下一行继续搜索。
		// (2) 如果mid小于当前行最后一个元素，那么就从这一行后面元素开始比较，然后col--比较前面的
		int n = matrix.length;
		int row = 0;
		int col = n - 1;

		int count = 0;
		while (row < n && col >= 0) {
			System.out.println("===> row:" + row + "|col:" + col + "|matrix[row][col]:" + matrix[row][col]);
			if (mid >= matrix[row][col]) {
				count += col + 1;
				row++;
				System.out.println("---- adding count:" + count);
			} else {
				col--;
			}
		}
		return count;
	
	}

	public static void main(String[] args) {
		LC0378kthSmallest test = new LC0378kthSmallest();

		int[][] matrix = new int[][] { 
			{ 1, 5, 9 }, 
			{ 2, 11, 13 }, 
			{ 3, 13, 15 } };

		int res = test.kthSmallest(matrix, 3);
		System.out.println(res);

	};
}
