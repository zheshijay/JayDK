package algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC0167TwoSum {
	/*
	 * Solution 1:
	 */
	 public int[] twoSum(int[] nums, int target) {
	        int p1=0, p2 = nums.length-1;
	        while (p1 < p2){
	            int sum = nums[p1] + nums[p2];
	            if (sum == target) {
	                return new int[]{p1 + 1, p2 + 1};
	            } else if (sum < target) {
	                p1++;
	            } else {
	                p2--;
	            }
	        }

	        return new int[]{-1, -1};
	    }
	 
	 public int[] twoSum2(int[] numbers, int target) {
	        int low = 0, high = numbers.length - 1;
	        while (low < high) {
	            int sum = numbers[low] + numbers[high];
	            if (sum == target) {
	                return new int[]{low + 1, high + 1};
	            } else if (sum < target) {
	                ++low;
	            } else {
	                --high;
	            }
	        }
	        return new int[]{-1, -1};
	    }
	 
	 public static void main(String[] args) {
		int[] nums = new int[] {2,7,11,15};
		int target = 9;
		
		LC0167TwoSum test = new LC0167TwoSum();
		int[] res = test.twoSum(nums, target);
		System.out.println(Arrays.toString(res));
		
		
	}
}
