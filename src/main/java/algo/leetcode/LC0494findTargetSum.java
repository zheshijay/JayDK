package algo.leetcode;

import java.util.Arrays;
import java.util.Stack;

/*
输入：nums: [1, 1, 1, 1, 1], S: 3
输出：5
解释：

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

一共有5种方法让最终目标和为3。
 */
public class LC0494findTargetSum {
	int count, remain;

	public int findTargetSumWays(int[] nums, int S) {
		count = 0;
		remain = S;
		dfs(nums, 0);
		return count;
	}

	void dfs(int[] nums, int level) {
		if (level == nums.length ) {
			if (remain == 0) {
				count++;
			}
			return;
		}
		
		
		remain += nums[level];
		dfs(nums, level+1);
		remain -=nums[level];
		
		remain -= nums[level];
		dfs(nums, level+1);
		remain +=nums[level];
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {1, 1, 1, 1, 1};
		int S = 3;
		
		LC0494findTargetSum test = new LC0494findTargetSum();
		int res = test.findTargetSumWays(nums, S);
		System.out.println("res:" + res);
		
		
	}
}
