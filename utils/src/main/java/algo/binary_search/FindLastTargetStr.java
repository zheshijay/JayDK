package algo.binary_search;

public class FindLastTargetStr {

	public int findLastTarget(int nums[], int target){

		int start=0, end = nums.length-1;

		while(start + 1 < end){

			System.out.println("start:" + start + " end:"+end);

			int mid = ( start + end ) /2;

			if(target > nums[mid]){
				start = mid + 1;
			}else if(target < nums[mid]){
				end = mid-1;
			}else{
				start = mid;
			}
		}

		if(nums[end] == target) return end;
		return -1;
	}










	//------------------------
	//9:32 ~ 9:34    2 mins!

	public int findLastIndex(int[] nums, int target){
		int start=0, end=nums.length-1;

		while(start+1<end){
			int mid = (start+end)/2;

			if(target > nums[mid]){
				start =mid+1;
			}else if(target < nums[mid]){ 
				end = mid -1;
			}else{
				start = mid;
			}
		}
		if(nums[end] == target) return end;
		return -1;

	}




	public static void main(String[] args){


		FindLastTargetStr test = new FindLastTargetStr();

		int[] nums = new int[]{1,1,2,2,3,4,4};
		int target=2;

		System.out.println(test.findLastIndex(nums, target));


	}

}
