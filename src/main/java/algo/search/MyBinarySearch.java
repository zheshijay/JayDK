package algo.search;

import java.util.Arrays;

public class MyBinarySearch {

	public static boolean binarySearch(int[] nums, int target){
		if(nums.length < 0) return false;

		Arrays.sort(nums);

		int low = 0;
		int high = nums.length-1;

		int mid = (low + high) / 2;

		while(low<high){
			if(nums[mid] < target) low = mid + 1;
			if(nums[mid] > target) high = mid - 1;
			if(nums[mid] == target) return true;

			mid = (low + high) / 2;
		}
		return false;
	}

	public static boolean shiftedBinarySearch(int[] nums, int key){
		//Sort the array
		//		Arrays.sort(nums);

		for(int num: nums){
			System.out.print(num + " ");
		}

		//find shift ( find the 1st element less the the first element of the array )
		int shiftIndex = 0;
		int mid = nums[0];
		for(int i=0; i < nums.length; i++){
			if(nums[i] < mid){
				shiftIndex = i;
				break;
			}
		}
		System.out.print("shiftIndex: " + shiftIndex);


		// low-shiftIndex,   shiftIndex-( nums.length - 1)
		int low1 = 0;
		int high1 = shiftIndex;
		
		// Do binary search for 2 sorted array
		
		while(low1<high1){
			if(nums[mid] < key) 
				low1 = mid + 1;
			else if(nums[mid] < key) 
				high1 = mid - 1;
			else 
				return true;

			mid = (low1 + high1) / 2;
		}
		
		
		int low2 = 0;
		int high2 = nums.length - 1;
		while(low2<high2){
			if(nums[mid] < key) 
				low2 = mid + 1;
			else if(nums[mid] < key) 
				high2 = mid - 1;
			else 
				return true;

			mid = (low2 + high2) / 2;
		}
		
		return false;
	}

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7,8,9};
		System.out.println(MyBinarySearch.binarySearch(nums, 1
				));
		
		int[] shiftedNums = {5,6,7,8,9,1,2,3,4};
		System.out.println(MyBinarySearch.shiftedBinarySearch(nums, 99));
	}

}
