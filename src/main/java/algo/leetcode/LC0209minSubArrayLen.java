package algo.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LC0209minSubArrayLen {

	/*
	 * Solution 1: 暴力
	 */
	public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= s) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
	
	/*
	 * Solution 2: 2 pointers
	 */
	public int minSubArrayLen2(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

	
	
	public int minSubArrayLenTemp(int s, int[] nums) {
		int len = nums.length;
		if(len == 0) {
			return 0;
		}
		
		int res = Integer.MAX_VALUE;
		int sum = 0;
		int start = 0;
		for(int i=0;i<len; i++) {
			sum+=nums[i];
			while(sum >=s) {
				res = Math.min(i-start+1, res);
				sum-=nums[start++];
			}
		}
		
		return res == Integer.MAX_VALUE ? 0 : res;
	}
	
	
	// Driver code
	public static void main(String args[]) {
		LC0209minSubArrayLen test = new LC0209minSubArrayLen();
		int nums[] = {2,3,1,2,4,3};
		int s = 7;
//		printKMax(arr, arr.length, k);
		int res = test.minSubArrayLenTemp(s, nums);
		System.out.println(res);
	}
}
