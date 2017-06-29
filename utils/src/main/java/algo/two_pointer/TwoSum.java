package algo.two_pointer;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;

import org.junit.Test;

public class TwoSum {
	/*
	 * 
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. 
Please note that your returned answers (both index1 and index2) are not zero-based.

For example:

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=0, index2=1

	 */
	
	
	//start: 9:14 am
	//done: 9:18 am

	//use buffer
	public int[] twoSum(int[] nums, int k){
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0; i < nums.length; i++){
			
			if(!map.containsKey(nums[i])){
				map.put(k - nums[i], i);
			}else{ //found it
				return new int[]{map.get(nums[i]), i};	
			}
		}
		
		return new int[]{0,0};
		
	}

	//USE 2 pointer   without buffer (sorted array)  
		public int[] twoSumWithoutBuffer(int[] nums, int k){
		
			int leftP = 0, rightP = nums.length-1;
			
			while(leftP < rightP){
				int curSum = nums[leftP] + nums[rightP];
				
				if(curSum < k) leftP++;
				else if(curSum>k)leftP--;
				else{
					return new int[]{leftP, rightP};					
				}
			}
			return null;
		}
		
	
	public static void main(String args[]){
		TwoSum test = new TwoSum();
		
		
		System.out.println(Arrays.toString(test.twoSum(new int[]{-2, -7, 11, 15}, 4)));
		
	}
	
	
	
	
	
	
	@Test
	public void testMyCode(){
		
		TwoSum test = new TwoSum();
		
		//test case 01
		int[] nums = new int[]{2, 7, 11, 15};
		
		int[] res = test.twoSumWithoutBuffer(new int[]{2, 7, 11, 15}, 18);
		
		System.out.println(res);
		
		
	}
	
	
}
