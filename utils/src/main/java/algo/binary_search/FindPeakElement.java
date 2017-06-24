package algo.binary_search;

/*
 * 
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 * 
 */
public class FindPeakElement {
	public int findPeakElement(int[] nums){
		if(nums.length ==0) return -1;
		int start = 0, end = nums.length-1;
		while(start+1<end){
			int mid = (start+end)/2;
			
			//condition 1: current element is peak
			if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
				return nums[mid];
			}else if(nums[mid] > nums[mid-1] && nums[mid] < nums[mid+1]){
				start=mid;
			}else if(nums[mid] < nums[mid-1] && nums[mid] > nums[mid+1]){
				end = mid;
			}else if(nums[mid] > nums[mid-1] && nums[mid] < nums[mid+1]){
				start=mid;
			}
		}
		if(start >=1 && ( nums[start]>nums[start-1] && nums[start] <nums[start+1]) ) return nums[start];
		if(end <=nums.length-2 && ( nums[end]>nums[end-1] && nums[end] < nums[end+1]) ) return nums[end];
		return -1;
	}
	
	public static void main(String[] args){
		FindPeakElement test = new FindPeakElement();
		int[] nums = new int[]{1,2,3,4,5,6,5,7};
		System.out.println(test.findPeakElement(nums));
	}
}
