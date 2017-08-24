package algo.string_and_array;

public class FindPeakElement {
	/*
	 * 
	 * 
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] â‰? num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -âˆ?.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
	 */


	/**
	 * @param A: An integers array.
	 * @return: return any of peek positions.
	 */
	public int findPeakUseBS(int[] A) {
		// write your code here
		int low = 1, high = A.length-2; // 1.ç­”æ¡ˆåœ¨ä¹‹é—´ï¼Œ2.ä¸ä¼šå‡ºç•Œ 
		while(low + 1 <  high) {

			int mid = (low + high) / 2;

			if(A[mid] < A[mid - 1]) {
				high = mid;
			} else if(A[mid] < A[mid + 1]) {
				low = mid;
			} else {
				high = mid;
			}
		}
		if(A[low] < A[high]) {
			return high;
		} else { 
			return low;
		}
	}


	/**
	 * @param A: An integers array.
	 * @return: return any of peek positions.
	 */
	public int findPeakUseNaive(int[] nums) {
		for(int i=1; i< nums.length; i++){
			if(nums[i] > nums[i-1] && nums[i] > nums[i+1]) return nums[i];

		}
		return -1;
	}
	

	public int myFindPeakUseBS(int[] nums) {

		int low=0, high=nums.length-1, mid = ( low + high) /2;

		while(low+1 < high){
			System.out.println(" low : " + low + " high: " + high);

			if( nums[mid+1] > nums[mid]){
				low = mid;
			}else if( nums[mid-1] > nums[mid]){
				high=mid;
			}else{
				return nums[mid];
			}

			mid = ( low + high) /2;
		}

		if(nums[low] > nums[high]) return nums[low];
		else return nums[high];

	}



	//	[1, 2, 3, 4ï¼? 5ï¼? 4ï¼? 6ï¼? 7ï¼? 6]
	//best solution
	public int myFindPeak(int[] nums){
		
		int low=0, high=nums.length-1, mid = (low+high)/2;
		
		while(low+1 < high){
			
			if(nums[mid + 1] > nums[mid]){
				low = mid;
			}else if(nums[mid-1] < nums[mid]){
				high = mid;
			}else{
				return nums[mid];
			}
			mid = (low+high)/2;
		}
		
		if(nums[low] > nums[high]) return nums[low];
		else return nums[high];

	}

	public static void main(String[] args){
		int[] nums = new int[]{1,2,3,4,6,4,2};

		FindPeakElement test = new FindPeakElement();

		int res = test.myFindPeak(nums);

		System.out.println(res);




	}

}
