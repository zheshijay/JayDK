package algo.string_and_array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
/*
 * 
 * 
 * 
 * Given an array of integers, find if the array contains any duplicates. 
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 * 
 */

	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < nums.length; i++){
			if(i > k) set.remove(nums[i-k-1]);
			if(!set.add(nums[i])) return true;
		}
		return false;
	}


	  public static boolean containsDuplicate(int[] nums) {
	       Set<Integer> set = new HashSet<Integer>();
	        for(int num: nums){
	            if(!set.add(num)) return true;
	        }
	        return false;
	    }


	public static void main(String args[]){
		System.out.println(ContainsDuplicate.containsDuplicate(new int[]{0, 1, 2, 3, 4, 5}));


	}
}
