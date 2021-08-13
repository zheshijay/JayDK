package algo.leetcode;

public class LC0922sortArrayByEvenOdd {

	public int[] sortArrayByParityII(int[] nums) {

		// i: even index
		// j: odd index
		int j = 1;
		for (int i = 0; i < nums.length; i += 2) {
			// nothing to execute if nums[i] is even number
			// But when nums[i] is odd number, we need find the next odd number and swap
			if (nums[i] % 2 == 1) {

				while (nums[j] % 2 == 1) {
					j += 2;
				}

				swap(nums, i, j);
			}

		}

		return nums;
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 4, 2, 5, 7 };

	}
}
