package algo.string_and_array;

import java.util.Arrays;

public class MoveZeroToEnd {
	static void pushZerosToEnd(int nums[])
    {
		System.out.println(" original : " + Arrays.toString(nums));
		
		
        int count = 0;  // Count of non-zero elements
 
        // Traverse the array. If element encountered is
        // non-zero, then replace the element at index 'count'
        // with this element
        for (int i = 0; i < nums.length; i++){
        	System.out.println(" --> count: " + count);
        	
        	 if (nums[i] != 0){
        		 
        		 System.out.println(" --> swap: " +  nums[count+1] + " and " + nums[i]);
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
	
	
	public static void main(String args[]){
		int[] nums = new int[]{1, 2, 0, 3, 4, 0, 5, 6, 7};
		MoveZeroToEnd.pushZerosToEnd(nums);
		System.out.println(Arrays.toString(nums));
		
	}
}
