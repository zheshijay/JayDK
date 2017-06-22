package algo.string_and_array;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity? 

 * 
 * @author ZShi
 *
 */
public class FindMissingNum {
	public static int findMissingNum(int[] nums) {

        int sum = 0;
        for(int num: nums)
            sum += num;
        
        return (nums.length * (nums.length + 1) )/ 2 - sum;
	}
	
	
	public static void main(String args[]){
		System.out.println(FindMissingNum.findMissingNum(new int[]{0, 1, 3}));
		
		
	}
}
