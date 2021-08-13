package algo.leetcode;

import java.util.Arrays;

public class BinarySearch {

	private static boolean binarySearch(int[] nums, int key) {
		//Sort the array
		Arrays.sort(nums);

		for(int num: nums){
			System.out.print(num + " ");
		}

		int low = 0;
		int high = nums.length-1;
		//		int mid = (low + high) / 2;

		System.out.println("====> start low: " +low +  " high: " + high);

		while(low<=high){
			int mid = (low + high) / 2;

			if(nums[mid] < key) 
				low = mid + 1;
			else if(nums[mid] > key) 
				high = mid - 1;
			else 
				return true;
		}
		return false;
	}

	private static boolean shiftedBinarySearch(int[] nums, int key) {
		//Sort the array
		//		Arrays.sort(nums);

		for(int num: nums){
			System.out.print(num + " ");
		}

		//find shift ( find the 1st element less the the first element of the array )
		int shiftIndex = 0;
		int header = nums[0];
		for(int i=0; i < nums.length; i++){
			if(nums[i] < header){
				shiftIndex = i;
				break;
			}
		}
		System.out.print("shiftIndex: " + shiftIndex);


		// low-shiftIndex,   shiftIndex-( nums.length - 1)
		int low1 = 0;
		int high1 = shiftIndex;

		//
		while(low1<=high1){
			int mid = (low1 + high1) / 2;
			
			if(nums[mid] < key) 
				low1 = mid + 1;
			else if(nums[mid] < key) 
				high1 = mid - 1;
			else 
				return true;

			
		}

		int low2 = shiftIndex;
		int high2 = nums.length - 1;
		while(low2<=high2){
			int mid = (low2 + high2) / 2;
			
			if(nums[mid] < key) 
				low2 = mid + 1;
			else if(nums[mid] < key) 
				high2 = mid - 1;
			else 
				return true;

		
		}

		return false;
	}

	public static void main(String[] args) {
		//		int[] nums = {1,3,5,7,9,8,6,4,2};

		//		System.out.println(binarySearch(nums, 10)); 
		int[] nums = {3,4,5,6,1,2};
		System.out.println(shiftedBinarySearch(nums, 4)); 

	}



}
