package algo.string_and_array;

import java.util.Arrays;

public class ArrayPlusArray {


	/**
	 * 

[1, 2, 3, 4]
      [4, 5]


	 */

	public int[] arrayPlusArray(int[] nums1, int[] nums2){
		int carry = 0, sum = 0;
		int[] res = new int[nums1.length];

		for (int i = nums1.length - 1; i >= 0 ; i--) {
			sum = nums1[i] + nums2[i] + carry;
			res[i] = sum%10;
			carry = sum/10;
			System.out.println("carry is: " + carry);		    
		}

		if(carry > 0){
			int[] res2 = new int[res.length + 1];
			System.arraycopy(res, 0, res2, 1, res.length);
			res2[0] = 1;
			return res2;
		}

		return res;
	}


	public static void main(String args[]){
		ArrayPlusArray test = new ArrayPlusArray();

		int[] nums1 = new int[]{1,2,3};
		int[] nums2 = new int[]{9,5,6};

		System.out.println(Arrays.toString(test.arrayPlusArray(nums1, nums2)));
	}

}
