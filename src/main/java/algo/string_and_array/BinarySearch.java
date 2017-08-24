package algo.string_and_array;

public class BinarySearch {
	public boolean binarySearch(int[] nums, int k) {

		int low=0, high = nums.length-1, mid=0;

		while(low < high){

			mid = ( low + high ) / 2;
			
			if(k == nums[mid]) return true;

			if(k > nums[mid]) low= mid +1;

			if(k < nums[mid]) high= mid -1;

			
		}

		return false;

	}



	public static void main(String[] args) {
		BinarySearch test = new BinarySearch();
		int[] nums = new int[]{100, 4, 200, 1, 3, 2};
		// String[] strs = new String[]{"apple", "ape", "april"};
		System.out.println("result is: " + test.binarySearch(nums, 23));

	}
}
