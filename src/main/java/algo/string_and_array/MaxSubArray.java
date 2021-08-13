package algo.string_and_array;

public class MaxSubArray {

	/*
	 * Find the contiguous sub-array within an array (containing at least one
	 * number) which has the largest sum.
	 * 
	 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4], the contiguous subarray
	 * [4,-1,2,1] has the largest sum = 6.
	 * 
	 */
	public static int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
}

	public static void main(String[] args) {
		MaxSubArray test = new MaxSubArray();

		int[] nums = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

		int res = test.maxSubArray(nums);

		System.out.println(res);

	}

}
