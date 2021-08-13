package algo.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC0108setZeroesIn2DArray {
	public void setZeroes(int[][] nums) {
		Set<Integer> rows = new HashSet<>();
		Set<Integer> cols = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[0].length; j++) {
				if (nums[i][j] == 0) {
					rows.add(i);
					cols.add(j);
				}
			}
		}

		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[0].length; j++) {
				if (rows.contains(i) || cols.contains(j)) {
					nums[i][j] = 0;
				}
			}
		}

	}

	public static void main(String[] args) {
		LC0108setZeroesIn2DArray test = new LC0108setZeroesIn2DArray();
//		int[][] nums = new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		
		int[][] nums = new int[][] { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };

		System.out.println("--- Before ---");
		System.out.println(Arrays.deepToString(nums).replace("], ", "]\n"));
		test.setZeroes(nums);

		System.out.println("--- After ---");
		System.out.println(Arrays.deepToString(nums).replace("], ", "]\n"));

	}
}
