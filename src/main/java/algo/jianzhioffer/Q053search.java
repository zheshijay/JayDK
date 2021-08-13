package algo.jianzhioffer;

/*
输入两个链表，找出它们的第一个公共节点。
 */

public class Q053search {
	public int search(int[] nums, int target) {
		// 搜索右边界 right
		int i = 0, j = nums.length - 1;
		while (i <= j) {
			int m = (i + j) / 2;
			if (nums[m] <= target)
				i = m + 1;
			else
				j = m - 1;
		}
		int right = i;
		// 若数组中无 target ，则提前返回
		if (j >= 0 && nums[j] != target)
			return 0;
		// 搜索左边界 right
		i = 0;
		j = nums.length - 1;
		while (i <= j) {
			int m = (i + j) / 2;
			if (nums[m] < target)
				i = m + 1;
			else
				j = m - 1;
		}
		int left = j;
		return right - left - 1;
	}

	/*
	 * Solution 2: find right for target and target -1
	 */
	public int search2(int[] nums, int target) {
		return helper(nums, target) - helper(nums, target - 1);
	}

	int helper(int[] nums, int tar) {
		int i = 0, j = nums.length - 1;
		while (i <= j) {
			int m = (i + j) / 2;
			if (nums[m] <= tar)
				i = m + 1;
			else
				j = m - 1;
		}
		return i;
	}

}