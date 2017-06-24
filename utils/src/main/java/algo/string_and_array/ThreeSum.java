package algo.string_and_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 
 * 
Problem:

Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a �� b �� c)
The solution set must not contain duplicate triplets.

    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
 */

public class ThreeSum {
	
	/*
	 * 
	 * a + b + c = 0
	 * 
	 * my solution: 
	 * (1) Use buffer: hashmap     this question can be convert to 2 sum question find 2 elements which equals -c
	 * 
	 * (2) Use 2 pointer, check target with nums[left] + nums[right]
	 * 
	 */
	 public List<List<Integer>> myThreeSum(int[] nums) {
		 Arrays.sort(nums);
		 List<List<Integer>> res = new ArrayList<List<Integer>>();
		 for(int i=0; i < nums.length; i++){
			 
			 int curNum = nums[i];
			 
			 //avoid duplicate
			 if(i>0 && curNum == nums[i-1]) continue;
			 
			 int target = -curNum;
			 
			 
			 int leftP = i+1, rightP = nums.length-1;
			 
			 while(leftP < rightP){
				 
				 if( (target > nums[leftP] + nums[rightP])) 
					 leftP++; 
				 else if( target < nums[leftP] + nums[rightP] ) 
					 rightP--;
				 else{
					 //found it
					 List<Integer> indice = new ArrayList<Integer>();
					 indice.add(nums[i]);
					 indice.add(nums[leftP]);
					 indice.add(nums[rightP]);
					 res.add(indice);
					
					 leftP++;
					 rightP--;
					 
					 //avoid duplicate
					 while(leftP < rightP && nums[leftP] == nums[leftP-1]) leftP++;
					 while(leftP < rightP && nums[rightP] == nums[rightP+1]) rightP--;
					 

					 
					 
					 
					 // -3, -3, -2, -1, 0, 1, 2, 2, 3, 3
				 }
			 }
			 
		 }
		 return res;
	 }
	
	public static void main(String args[]){
		ThreeSum threeSum = new ThreeSum();
		List<List<Integer>> res = threeSum.myThreeSum(new int[]{-2, -2, -1, 0, 1, 2, 2, 2, 3 });
			
		System.out.println(res);

	}


}
