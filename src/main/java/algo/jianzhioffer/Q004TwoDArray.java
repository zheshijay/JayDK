package algo.jianzhioffer;

import java.util.HashSet;
import java.util.Set;

public class Q004TwoDArray {
	/*
	 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

例如下面的二维数组就是每行、每列都是递增排序，如果在这个数组中查找数字7，则放回true；如果查找数字5，由于数组不含该数字，则返回false。

	1 2 8 9
	2 4 9 12
	4 7 10 13
	6 8 11 15
	 */

	public boolean containsNum(int target, int[][] nums) {
		if (nums.length < 1) {
			return false;
		}

		int x = 0;
		int y = nums[0].length-1;
		
		while(y >= 0 && x <= nums.length -1) {
			if (nums[x][y] == target) {
				return true;
			} else if (nums[x][y] > target) {
				y--;
			} else {
				x++;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Q004TwoDArray test = new Q004TwoDArray();
		
		int target = 3;
		int[][] nums = new int[][] {
			{1, 2, 8, 9},
			{2, 4, 9, 12},
			{4, 7, 10, 13},
			{6, 8, 11, 15}
		};
		
		System.out.println(test.containsNum(target, nums));
	}
}
