package algo.string_and_array;

import java.util.Arrays;

/**
 * 
 * 
Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.

Subscribe to see which companies asked this question.

 */

public class PlusK {
	
	public int[] plusK(int[] nums, int k) {
		
		int[] res = null;
		
		int carry = k;
		for(int i=nums.length -1; i>=0; i--){
			int newVal = (nums[i] + carry) % 10;
			carry = (nums[i] + carry) / 10;
			nums[i] = newVal;
		}
		
		if(carry >0){
			res = new int[nums.length + 1];
			System.arraycopy(nums, 0, res, 1, nums.length);
			res[0] = 1;
		}else return nums; 
			
		
		return res;
		
	}
	
	
	public int[] plusOne(int[] digits) {
        
	    int n = digits.length;
	    
	    for(int i=n-1; i>=0; i--) {
	        if(digits[i] < 9) {
	            digits[i]++;
	            System.out.println(" set digits[" + i + "] to " + ( digits[i]+1 ));
	            
	            return digits;
	        }else{ //last digit >9, set to o
	        	 System.out.println(" set digits[" + i + "] to 0");
	 	        digits[i] = 0;
	        }
	    }
	    
	    int[] newNumber = new int [n+1];
	    newNumber[0] = 1;
	    
	    System.out.println("newNumber is: " + newNumber);
	    
	    return newNumber;
	}

	public static void main(String[] args){
		PlusK test = new PlusK();
		
		int[] nums = new int[]{9,2,9};

		int[] res = test.plusK(nums, 1);
		
		System.out.println(Arrays.toString(res));
		
//		ArrayUtil.printArray(res);
	}
}
