package algo.string_and_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumClosest {
	
	/*
	 * 
LeetCode �C 3Sum Closest (Java)
 
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
Return the sum of the three integers. You may assume that each input would have exactly one solution.

For example, given array S = {-1 2 1 -4}, and target = 1. 
The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
	 * start: 11:35 am
	 * finish: 11:45 am
	 */
	 public int findClosest(int[] nums, int k) {
		
		 int res = -1;
		 
		 int closestVal = Integer.MAX_VALUE;
		 
		 for( int i=0; i< nums.length; i++){
			 int target = k-nums[i];
			 
			 
			 System.out.println("target is:" + target);
			 
			 int leftP=i+1, rightP=nums.length-1;
			 while(leftP < rightP){
				 
				 System.out.println("left:" + nums[leftP] + "rightP:" + nums[rightP]);
				 
				 int sum = nums[i] + nums[leftP] + nums[rightP];
				 int diff = Math.abs(sum-k);
				 
				 //check diff
				 if(diff < closestVal){
					 closestVal = diff;
					 res = sum;
					 System.out.println("closet values: " + nums[leftP] + "-" + nums[rightP] + "-" + nums[i]);
				 }
				 
				 if(target > nums[leftP] + nums[rightP]) {
					 leftP++;
				 }
				 else if(target < nums[leftP] + nums[rightP]){
					 rightP--;
				 }else{
					 //found 3 element equals to k
					 return k;
				 }

			 }
		 }
		 
		 return res;
		 
		 
	 }
	
	public static void main(String args[]){
		ThreeSumClosest threeSumClosest = new ThreeSumClosest();
		int res = threeSumClosest.findClosest(new int[]{1,2,3,4,5}, 122);
			
		System.out.println(res);

	}
}
