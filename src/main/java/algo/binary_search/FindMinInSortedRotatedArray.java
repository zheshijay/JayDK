package algo.binary_search;

public class FindMinInSortedRotatedArray {
	
	/*
	 * 
	 * 
	 * 

Find the minimum element in a sorted and rotated array

A sorted array is rotated at some unknown point, find the minimum element in it.

Following solution assumes that all elements are distinct.

Examples

Input: {5, 6, 1, 2, 3, 4}
Output: 1

Input: {1, 2, 3, 4}
Output: 1

Input: {2, 1}
Output: 1
	 */
	
	
	public int findMin(int[] nums){
		int start = 0, end = nums.length-1;
		
		int target = nums[nums.length-1];
		
		while(start + 1 < end){
			int mid = ( start + end ) / 2;
			
			if( nums[mid] >= target ) start=mid;
			else if(nums[mid] < target) end=mid;
		}
		
		if(nums[start] <=target){
			return start;
		}else return end;
	}
	
	public static void main(String[] args){
		FindMinInSortedRotatedArray test = new FindMinInSortedRotatedArray();
		int[] nums = new int[]{5, 6, 1, 2, 3, 4};
		
		System.out.println(test.findMin(nums));
		
	}
	
	

}
