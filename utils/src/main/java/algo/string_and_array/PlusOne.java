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

public class PlusOne {
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
		PlusOne test = new PlusOne();
		
		int[] nums = new int[]{9,9,9};

		int[] res = test.plusOne(nums);
		
		System.out.println(Arrays.toString(res));
		
//		ArrayUtil.printArray(res);
	}
}
