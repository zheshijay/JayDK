package algo.topk;

public class LC0215findKthLargest_S1_QuickSortTest {

	/*
	 * Insert sort: the Kth pivot is the answer
	 */
	public int findKthLargest(int[] nums, int k) {
		int left= 0, right = nums.length-1;
		int target = nums.length - k;

		while(true) {
			int pivot = partition(nums, left, right);
			if (pivot == target) {
				return nums[pivot];
			} else if (pivot < target) {
				left = pivot+1;
			} else {
				right = pivot-1;
			}
		}
		

	}

	private int partition(int[] nums, int left, int right) {
		int pivot = nums[right];
		int index = left;
		for (int i = left; i< right; i++) {
			if(nums[i] < pivot) {
				swap(nums, i, index++);
			}
		}
		swap(nums, index, right);
		return index;
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	// Driver code
	public static void main(String args[]) {
		LC0215findKthLargest_S1_QuickSortTest test = new LC0215findKthLargest_S1_QuickSortTest();

//		int[] nums = new int[] { 1, 2, 3, 4, 5 };
		int[] nums = new int[] { 4, 5, 1, 2, 3 };

		int res = test.findKthLargest(nums, 2);
		System.out.println("res:" + res);
	}
}
