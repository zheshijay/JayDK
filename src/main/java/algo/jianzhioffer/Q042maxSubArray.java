package algo.jianzhioffer;

/*
输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。

要求时间复杂度为O(n)。

 */

public class Q042maxSubArray {
	 public int maxSubArray(int[] nums) {
		 if (nums == null || nums.length == 0) return 0;

		 int[] dp = new int[nums.length];
		    dp[0] = nums[0];
		    int max = dp[0];
		    for(int i = 1; i < nums.length; i++) {
		        dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
		        max = Math.max(max, dp[i]);
		    }
		    return max;
	 }
	 
	 public int maxSubArray2(int[] nums) {
	        int ans = Integer.MIN_VALUE, sum = 0;
	        for(int num : nums) {
	            sum = Math.max(sum + num, num);
	            ans = Math.max(ans, sum);
	        }
	        return ans;
	    }

}