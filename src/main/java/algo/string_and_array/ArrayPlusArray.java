package algo.string_and_array;

import java.util.Arrays;

public class ArrayPlusArray {

	/**
	 * 
	 * 
	 * [1, 2, 3, 4] [4, 5]
	 * 
	 * 
	 */

	public int[] arrayPlusArray(int[] nums1, int[] nums2) {
		int carry = 0, sum = 0;
		int[] res = new int[nums1.length];

		int length = Math.max(nums1.length, nums2.length);

		if (nums1.length < length) {
			nums1 = resizeArray(nums1, length);
		}

		if (nums2.length < length) {
			nums2 = resizeArray(nums2, length);
		}
		
		
		System.out.println("nums1:" + Arrays.toString(nums1));
		System.out.println("nums2:" + Arrays.toString(nums2));

		for (int i = nums1.length - 1; i >= 0; i--) {
			sum = nums1[i] + nums2[i] + carry;
			res[i] = sum % 10;
			carry = sum / 10;
			System.out.println("carry is: " + carry);
		}

		if (carry > 0) {
			int[] res2 = new int[res.length + 1];
			System.arraycopy(res, 0, res2, 1, res.length);
			res2[0] = 1;
			return res2;
		}

		return res;
	}
	
	int[] resizeArray(int[] a, int size) {
		int[] newA = new int[size];
		System.arraycopy(a, 0, newA, size - a.length, a.length);
		return newA;
	}

	public static void main(String args[]) {
		ArrayPlusArray test = new ArrayPlusArray();
//
//		int[] nums1 = new int[] { 1, 2, 3 };
//		int[] nums2 = new int[] {       9 };
		
		int[] nums1 = new int[] { 7, 2, 9 };
		int[] nums2 = new int[] { 4, 9, 6 };

		System.out.println(Arrays.toString(test.arrayPlusArray(nums1, nums2)));
		
//		int[] nums1 = new int[] { 1, 9 };
//		int[] newNums1 = new int[5];
//		System.arraycopy(nums1, 0, newNums1, newNums1.length-nums1.length, nums1.length);
//		System.out.println(Arrays.toString(nums1));
//		System.out.println(Arrays.toString(newNums1));
		
	}

}
