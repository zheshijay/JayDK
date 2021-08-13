package algo.string_and_array;

import java.util.Arrays;

import algo.utils.PrintUtils;

/*
给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
示例 2:

输入: [-1,-100,3,99] 和 k = 2
输出: [3,99,-1,-100]
解释: 
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]
说明:

尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
要求使用空间复杂度为 O(1) 的 原地 算法。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rotate-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RotateArray {

	/**
	 * 
	 * Solution 1 - Use Intermediate Array
	 * 
	 * [1,2,3,4,5,6,7]
	 * 
	 * [5,6,7,1,2,3,4]
	 */

	// Solution 1 - Intermediate Array
	public static int[] rotateArray(int[] nums, int k) {

		if (k > nums.length)
			k = k % nums.length;

		int[] copyOfNums = Arrays.copyOf(nums, nums.length);
		int[] res = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			res[(i + k) % nums.length] = copyOfNums[i];
		}

		return res;
	}


	/**
	 * 
	 * 
	 * 
	 * Solution 2 - Bubble Rotate
	 * 
	 * Can we do this in O(1) space?
	 * 
	 * This solution is like a bubble sort.
	 * 
	 */
	public static int[] rotate(int[] arr, int order) {
		if (arr == null || order < 0) {
			throw new IllegalArgumentException("Illegal argument!");
		}

		for (int i = 0; i < order; i++) {

			System.out.println(i + 1 + " round ");

			for (int j = arr.length - 1; j > 0; j--) {

				System.out.println("swap " + arr[j] + " and " + arr[j - 1]);

				int temp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
			}

			RotateArray.printArray(arr);

		}
		return arr;
	}

	/**
	 * 
	 * 
	 * Solution 3 - Reversal
	 * 
	 * Can we do this in O(1) space and in O(n) time? The following solution does.
	 * 
	 * Assuming we are given {1,2,3,4,5,6} and order 2. The basic idea is:
	 * 
	 * 1. Divide the array two parts: 1,2,3,4 and 5, 6 2. Reverse first part:
	 * 4,3,2,1,5,6 3. Reverse second part: 4,3,2,1,6,5 4. Reverse the whole array:
	 * 5,6,1,2,3,4
	 * 
	 * @param args
	 */

	public static void rotate_reversal(int[] arr, int order) {
		if (arr == null || arr.length == 0 || order < 0) {
			throw new IllegalArgumentException("Illegal argument!");
		}

		if (order > arr.length) {
			order = order % arr.length;
		}

		System.out.println(" order:" + order);

		// length of first part
		int a = arr.length - order;

		reverse(arr, 0, a - 1);
		reverse(arr, a, arr.length - 1);
		reverse(arr, 0, arr.length - 1);

	}

	public static void reverse(int[] arr, int left, int right) {
		if (arr == null || arr.length == 1)
			return;

		while (left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}

	public static void main(String args[]) {
		RotateArray test = new RotateArray();

		int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };

		test.rotate_reversal(nums, 3);

		System.out.println(Arrays.toString(nums));

		// test.printArray(rotated);

	}
}
