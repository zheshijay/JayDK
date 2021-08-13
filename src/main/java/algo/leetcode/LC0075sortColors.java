package algo.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LC0075sortColors {
	/*
	 * Solution 1: 1 pointer
	 */
	public void sortColors(int[] nums) {
		int n = nums.length;
		int ptr = 0;
		for (int i = 0; i < n; ++i) {
			if (nums[i] == 0) {
				int temp = nums[i];
				nums[i] = nums[ptr];
				nums[ptr] = temp;
				++ptr;
			}
		}
		for (int i = ptr; i < n; ++i) {
			if (nums[i] == 1) {
				int temp = nums[i];
				nums[i] = nums[ptr];
				nums[ptr] = temp;
				++ptr;
			}
		}
	}

	/*
	 * Solution 2: 2 pointer2 (https://leetcode-cn.com/problems/sort-colors/solution/yan-se-fen-lei-by-leetcode-solution/)
	 */
	 public void sortColors2(int[] nums) {
	        int n = nums.length;
	        int p0 = 0, p1 = 0;
	        for (int i = 0; i < n; ++i) {
	            if (nums[i] == 1) {
	                int temp = nums[i];
	                nums[i] = nums[p1];
	                nums[p1] = temp;
	                ++p1;
	            } else if (nums[i] == 0) {
	                int temp = nums[i];
	                nums[i] = nums[p0];
	                nums[p0] = temp;
	                if (p0 < p1) {
	                    temp = nums[i];
	                    nums[i] = nums[p1];
	                    nums[p1] = temp;
	                }
	                ++p0;
	                ++p1;
	            }
	        }
	    }
	

	// Driver code
	public static void main(String args[]) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int k = 3;
//		printKMax(arr, arr.length, k);
		printMax(arr, arr.length, k);
	}
}
