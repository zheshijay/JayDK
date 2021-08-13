package algo.topk;

import java.util.Collections;

public class LC0215findKthLargest_S1_QuickSort {
	/*
	 * Insert sort: the Kth pivot is the answer
	 */
	public int findKthLargest(int[] nums, int k) {

		int left = 0, right = nums.length - 1;
		int target = nums.length - k;

		while (true) {
			int pivotIndex = partition(nums, left, right);
			if (pivotIndex == target) {
				return nums[pivotIndex];
			} else if (pivotIndex < target) {
				left = pivotIndex + 1;
			} else {
				right = pivotIndex - 1;
			}
		}

	}

	private int partition(int[] nums, int left, int right) {
		int pivot = nums[left];
		int index = left;
		int i = left + 1;
		for (; i <= right; i++) {
			if (nums[i] < pivot) {
				index++;
				swap(nums, index, i);
			}
		}
		swap(nums, index, left);
		return index;
	}

	private void swap(int[] nums, int index1, int index2) {
		int temp = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = temp;
	}

	// Driver code
	public static void main(String args[]) {
		LC0215findKthLargest_S1_QuickSort test = new LC0215findKthLargest_S1_QuickSort();

//		int[] nums = new int[] { 1, 2, 3, 4, 5 };
		int[] nums = new int[] { 4, 5, 1, 2, 3  };

		int res = test.findKthLargest(nums, 2);
		System.out.println("res:" + res);
	}
}
