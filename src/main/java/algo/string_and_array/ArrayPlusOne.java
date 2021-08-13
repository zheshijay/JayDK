package algo.string_and_array;

import java.util.Arrays;

public class ArrayPlusOne {

	/**
	 * 
	 * 
	 * [1, 2, 3, 4] [4, 5]
	 * 
	 * 
	 */
	public int[] arrayPlusOne(int[] nums) {
		int sum = 0;
		int carry = 1;
		int p = nums.length -1;
		
		
		while (p >= 0) {
			sum = nums[p] + carry;
			nums[p] = sum%10;
			carry = sum/10;
			p--;
		}
		
		if (carry > 0) {
			int[] res = new int[nums.length + 1];
			System.arraycopy(nums, 0, res, 1, nums.length);
			res[0] = 1;
			return res;
		}
		
		return nums;
		
	}

	 public int[] plusOne2(int[] digits) {
	        for (int i = digits.length - 1; i >= 0; i--) {
	            digits[i]++;
	            digits[i] = digits[i] % 10;
	            if (digits[i] != 0) return digits;
	        }
	        digits = new int[digits.length + 1];
	        digits[0] = 1;
	        return digits;
	    }


	public static void main(String args[]) {
		ArrayPlusOne test = new ArrayPlusOne();

		int[] nums = new int[] { 1, 2, 3 };
//		int[] nums2 = new int[] { 9, 9 };

		System.out.println(Arrays.toString(test.plusOne2(nums)));
		
//		int[] nums1 = new int[] { 1, 9 };
//		int[] newNums1 = new int[5];
//		System.arraycopy(nums1, 0, newNums1, newNums1.length-nums1.length, nums1.length);
//		System.out.println(Arrays.toString(nums1));
//		System.out.println(Arrays.toString(newNums1));
		
	}

}
