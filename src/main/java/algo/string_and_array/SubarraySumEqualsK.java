package algo.string_and_array;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
/*
给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。

示例 1 :

输入:nums = [1,1,1], k = 2
输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
说明 :

数组的长度为 [1, 20,000]。
数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。

 */
	 public int subarraySum(int[] nums, int k) {
	        int count = 0;
	        for (int start = 0; start < nums.length; ++start) {
	            int sum = 0;
	            for (int end = start; end >= 0; --end) {
	                sum += nums[end];
	                if (sum == k) {
	                    count++;
	                }
	            }
	        }
	        return count;
	    }

	 public int subarraySum2(int[] nums, int k) {
	        int count = 0, pre = 0;
	        HashMap < Integer, Integer > mp = new HashMap < > ();
	        mp.put(0, 1);
	        for (int i = 0; i < nums.length; i++) {
	            pre += nums[i];
	            if (mp.containsKey(pre - k)) {
	                count += mp.get(pre - k);
	            }
	            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
	        }
	        return count;
	    }

	public static void main(String[] args) {
		SubarraySumEqualsK test = new SubarraySumEqualsK();
		int[] nums = new int[]{1,2,3,4};
		
//		int[] nums = new int[]{1,2,3,4,5,6,1};

		System.out.println(test.subarraySum(nums, 5));
	}
	
	

}
