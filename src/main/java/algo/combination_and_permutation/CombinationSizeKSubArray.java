package algo.combination_and_permutation;

import java.util.Arrays;

public class CombinationSizeKSubArray {
	
	/*
	 * 4 info needed for the recursion
	 * 1. info whether each index is used
	 * 2. current focus index
	 * 3. current size
	 * 4. size K
	 * 
	 */
	public static void main(String[] args){
		//test case
		int[] array = {1,2,3};
		int k=2;
		boolean[] used = new boolean[array.length];
		printAllSizeKSubset(array, used, 0,0,k);
	}

	static void printAllSizeKSubset(int[] nums, boolean[] used, int index, int currentSize, int k){
		//firstly define the base case
		
		//1. base case 1: the currentSIze ==K we print out
		if(currentSize == k) {
			for(int i=0; i<nums.length; i++){
				if(used[i]) {  System.out.print(" index " + i + " used  |　");   System.out.print("["+nums[i]+ "]");  }
			}
			System.out.println();
			return;
		}
		
		//2. base case 2:  focusIndex exceeds nums length
		if(index == nums.length) return;
		
		//key recursion
		used[index] = true;  //use this index
		printAllSizeKSubset(nums, used,  index+1,  currentSize+1,  k);
		
		used[index] = false;  //not use this index
		printAllSizeKSubset(nums, used,  index+1,  currentSize,  k);
		
		//please notice index is increasing no matter we use or not.
	}
}
