package algo.string_and_array;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
	/*
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
	 */

	public int subarraySum(int[] a, int k) {
		int sum = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			
			System.out.println("sum: " + sum);
			
			if (map.containsKey(sum - k)) {
				System.out.println("found sum-" + sum + " -k " + k);
				count += map.get(sum-k);
			}
			if (!map.containsKey(sum)) {
				System.out.println("-------------> adding:" + sum);
				map.put(sum, 1);
			} else {
				map.put(sum, map.get(sum) + 1);
			}
		}
		return count;
	}

	public int mySubarraySum(int[] nums, int k) {
		
		int count=0;
		Map<Integer, Integer> map = new HashMap<>();
		
		
		for (int i = 0; i < nums.length; i++) {
			
			if(!map.containsKey(nums[i])){
				map.put(k-nums[i], i);
			}else{
				
				int anotherIndex = map.get(nums[i]);
				if(Math.abs(anotherIndex - i) == 1){
					System.out.println("anotherIndex: " + anotherIndex + " - i: " + i);
					count++;
				}
				
				map.remove(nums[i]);
				map.put(k-nums[i], i);
				
			}
		}
		return count;
	}
	public static void main(String[] args) {
		SubarraySumEqualsK test = new SubarraySumEqualsK();
		int[] nums = new int[]{5, 1,2};
		
//		int[] nums = new int[]{1,2,3,4,5,6,1};

		System.out.println(test.subarraySum(nums, 3));
	}
	
	

}
