package algo.leetcode;

public class LC0283MoveZeroes {

	public void moveZeroesToEnd(int[] nums) {
		if (nums == null) {
			return;
		}
		// 第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
		int j = 0;
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] != 0) {
				nums[j++] = nums[i];
			}
		}

		// 非0元素统计完了，剩下的都是0了
		// 所以第二次遍历把末尾的元素都赋为0即可
		for (int i = j; i < nums.length; ++i) {
			nums[i] = 0;
		}
	}

	public void moveZeroesToFront(int[] nums) {
		if (nums == null) {
			return;
		}

		// 第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给 nums[j]
		int j = nums.length-1;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] != 0) {
				nums[j--] = nums[i];
			}
		}

		// 非0元素统计完了，剩下的都是0了
		// 所以第二次遍历把末尾的元素都赋为0即可
		for (int i = 0; i < j; ++i) {
			nums[i] = 0;
		}
	}

	/*
	 * Solution 2
	 */
	public void moveZeroes2(int[] nums) {
		int n = nums.length, left = 0, right = 0;
		while (right < n) {
			if (nums[right] != 0) {
				swap(nums, left, right);
				left++;
			}
			right++;
		}
	}

	public void swap(int[] nums, int left, int right) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LC0283MoveZeroes mz = new LC0283MoveZeroes();
		int[] nums = { 1, 0, 2, 0, 3, 4 };
//		mz.moveZeroesToEnd(nums);
		mz.moveZeroesToFront(nums);

		for (int eachInt : nums) {
			System.out.print(eachInt);
		}

	}

}
