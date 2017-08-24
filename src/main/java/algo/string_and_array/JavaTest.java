package algo.string_and_array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class JavaTest {
	
	
	public static void main(String args[]){
		
		int[] nums = new int[]{1,2,3};
		
		int[] newnums = new int[10];

		
		newnums = Arrays.copyOf(nums, nums.length);
		
		
		newnums[8] = 1;
		
		System.out.println(Arrays.toString(newnums));
		
		
		
	}
}
