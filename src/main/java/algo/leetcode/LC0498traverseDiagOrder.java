package algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC0498traverseDiagOrder {
	 public int[] findDiagonalOrder(int[][] nums) {

			if (nums == null || nums.length == 0) {
				return new int[0];
			}

			int m = nums[0].length;
	        int n = nums.length;

			int[] res = new int[m * n];
			int p = 0;

			List<Integer> temp = new ArrayList<>();

			for (int d = 0; d < m + n - 1; d++) {
				temp.clear();

				int r = d < m ? 0 : d - m + 1;
				int c = d < m ? d : m - 1;

				while (r < n && c >=0) {
					temp.add(nums[r][c]);
					r++;
					c--;
				}

				if (d % 2 == 0) {
					Collections.reverse(temp);
				}

				for (int i = 0; i < temp.size(); i++) {
					res[p++] = temp.get(i);
				}
			}
			return res;
		}
	
	public static void main(String[] args) {

		LC0498traverseDiagOrder test = new LC0498traverseDiagOrder();
		int[][] nums = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		
//		int[][] nums = new int[][] { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };


		int[] res = test.findDiagonalOrder(nums);

		System.out.println("--- After ---");
		System.out.println(Arrays.toString(res));

	
	}
}
