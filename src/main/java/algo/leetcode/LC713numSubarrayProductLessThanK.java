package algo.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LC713numSubarrayProductLessThanK {
	public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int now = 1, count = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            now *= nums[right];
            while (now >= k) now /= nums[left++];
            count += right - left + 1;
        }
        return count;
    }
	
	// Driver code
	public static void main(String args[]) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int k = 3;
//		printKMax(arr, arr.length, k);
		printMax(arr, arr.length, k);
	}
}
