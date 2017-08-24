package algo.string_and_array;

public class ArrayBinarySearch {




	/*
	 * 
	 * 
	 *   1,2,3,4,5,6
	 */


	public boolean findVal(int[] nums, int k){
		int low =0, high = nums.length-1;

		while(low <= high){
			int mid = ( low + high) /2;
			System.out.println("low: " + low + " mid is: " + mid + " high is: " + high + " -- nums[mid]:" + nums[mid]);

			if(nums[mid] < k){ //search on right side
				low = mid + 1;
			}else if(nums[mid] > k){
				high = mid - 1;
			}else {
				System.out.println(" found it");
				return true;
			}
		}
		return false;
	}





	public boolean myFindVal(int[] nums, int k){
		
		int low=0, high=nums.length-1, mid=(low + high)/2;
		
		while(low <= high){
			if(nums[mid] == k) return true;
			
			if(nums[mid] > k) high=mid-1;
			
			if(nums[mid] < k) low=mid+1;
			
			mid=(low + high)/2;
		}
		
		return false;
	}













	public static void main(String args[]){

		ArrayBinarySearch test = new ArrayBinarySearch();

		int[] nums = new int[]{1,2,3,4,8,78};

		boolean exist = test.myFindVal(nums, 5);

		System.out.println(exist);

	}
}
