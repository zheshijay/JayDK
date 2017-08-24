package algo.string_and_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode Find All Numbers Disappeared in an Array
 * 
Given an array of integers where 1 �� a[i] �� n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
 * 
 * 
 * 
 * 
 * 
 * 
 * @author ZShi
 *
 */

/*
 * 
Solutions1: from leetcode

use 2 for loop:
 first loop: mark appeared index to negitive value
 secibd loop: find the indices which has postive value 


My solution: I think it is the best



 * 
 */

public class FindMissingNum {
	public List<Integer> findDisappearedNumbers(int[] nums) {  
		List<Integer> ret = new ArrayList<Integer>();

		for(int i = 0; i < nums.length; i++) {
			int val = Math.abs(nums[i]) - 1;
			if(nums[val] > 0) {
				nums[val] = -nums[val];
			}
		}

		for(int i = 0; i < nums.length; i++) {
			if(nums[i] > 0) {
				ret.add(i+1);
			}
		}
		return ret;
	}

	
	//practice
	 public List<Integer> myFindDisappearedNumbers(int[] nums)
	    {
	        List<Integer> res = new ArrayList<Integer>();
	        
	    	boolean[] appeardIndices = new boolean[nums.length];

	    	
	    	for(int i=0; i<nums.length; i++){
	    		if(!appeardIndices[nums[i] - 1]){
	    			appeardIndices[nums[i] - 1] = true;
	    		}
	    	}
	    	
	    	for(int j=0; j<appeardIndices.length; j++){
	    		if(!appeardIndices[j]) res.add(j+1);
	    	}

	        return res;
	    }
	
	public static void main(String args[]){
		FindMissingNum test = new FindMissingNum();
		
		int[] nums = new int[]{4,3,2,7,8,2,3,1};

		List<Integer> res = test.myFindDisappearedNumbers(nums);
		
		System.out.println(res);
	}

}
