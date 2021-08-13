package algo.string_and_array;

import java.util.Arrays;

/*
 * 
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
说明:

必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/move-zeroes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 */

public class MoveZeroToEnd {
	static void pushZerosToEnd(int nums[]) {
		System.out.println(" original : " + Arrays.toString(nums));

		int count = 0; // Count of non-zero elements

		// Traverse the array. If element encountered is
		// non-zero, then replace the element at index 'count'
		// with this element
		for (int i = 0; i < nums.length; i++) {
			System.out.println(" --> count: " + count);

			if (nums[i] != 0) {

				System.out.println(" --> swap: " + nums[count + 1] + " and " + nums[i]);
				nums[count++] = nums[i]; // here count is
				// incremented
			}
			System.out.println(" --> : " + Arrays.toString(nums));
		}

		// Now all non-zero elements have been shifted to
		// front and 'count' is set as index of first 0.
		// Make all elements 0 from count to end.
		while (count < nums.length)
			nums[count++] = 0;
	}

	public static void moveZeroToEnd(int[] a) {
		int pointer = 0;
		for (int i = 0; i < a.length; i++) {

			if (a[i] != 0) {
				a[pointer++] = a[i];
			}
		}

		while (pointer < a.length) {
			a[pointer++] = 0;
		}
	}

	public static void main(String args[]) {
		int[] nums = new int[] { 1, 2, 0, 3, 4, 0, 5, 6, 7 };
		MoveZeroToEnd.moveZeroToEnd(nums);
		System.out.println(Arrays.toString(nums));

	}
}
