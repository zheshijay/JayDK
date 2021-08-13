package algo.string_and_array;

import java.util.Arrays;

public class ProductExceptSelf {

	

/**
For example, given [1,2,3,4], return [24,12,8,6].

 */
		

	public static int[] myProductExceptSelf5(int[] nums) {

		int[] res =  new int[nums.length];
		int[] left = new int[nums.length];
		int[] right = new int[nums.length];
		
		left[0] = 1;
		right[nums.length-1] = 1;
		
		for(int i = 1; i< nums.length; i++){
			left[i] = left[i-1] * nums[i-1];
		}
		
		System.out.println("left: "+Arrays.toString(left));
		
		for(int j = nums.length-2; j >= 0; j--){
			right[j] = right[j+1] * nums[j+1];
		}
		
		System.out.println("right: "+Arrays.toString(right));
		
		for(int k=0; k<nums.length; k++){
			res[k] = left[k] * right[k];
		}
		
		return res;
		
		
	}


	public static void main(String args[]){
		int[] product = myProductExceptSelf5(new int[]{1, 2, 3, 4});

		System.out.println(Arrays.toString(product));



	}
}
