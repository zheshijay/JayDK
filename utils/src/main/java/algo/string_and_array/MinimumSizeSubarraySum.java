package algo.string_and_array;

public class MinimumSizeSubarraySum {
	
	/*
	 * 
	 * 
	 * 
 Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint. 
	 * 
	 */

	/**
	 * @param nums: an array of integers
	 * @param s: an integer
	 * @return: an integer representing the minimum size of sub-array
	 */
	public int minimumSize(int[] nums, int s) {
		// write your code here
		int j = 0, i = 0;
		int sum =0;
		int ans = Integer.MAX_VALUE;
		
		for(i = 0; i < nums.length; i++) {
		
			while(j < nums.length && sum < s) {
				sum += nums[j];
				j ++;
			}

			if(sum >=s) {
				
				System.out.println(" compare ans:"+ans + " - (j-i):"+(j-i) );
				
				ans = Math.min(ans, j - i);
			}

			sum -= nums[i];
		}
		if(ans == Integer.MAX_VALUE)
			ans = 0;
		return ans;
	}

	public static void main(String[] args) {
		MinimumSizeSubarraySum test = new MinimumSizeSubarraySum();
		int[] nums = new int[]{2,3,1,2,4,3};
		System.out.println(test.minimumSize(nums, 7));

	}
}
