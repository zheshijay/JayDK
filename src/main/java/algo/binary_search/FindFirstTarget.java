package algo.binary_search;

public class FindFirstTarget {
	
	public int findFirstTarget(int nums[], int target){
		
		int start=0, end = nums.length-1;
		
		while(start+1 < end){
			System.out.println("start:" + start + " end:"+end);
			int mid = ( start + end ) /2;
			
			if(target > nums[mid]){
				start = mid + 1;
			}else if(target < nums[mid]){
				end = mid-1;
			}else{
				end = mid;
			}
		}
		
		if(nums[start] == target) return start;
		return -1;
	}
	

	public static void main(String[] args){
		
		
		FindFirstTarget test = new FindFirstTarget();
		
		int[] nums = new int[]{0,0,1,1,4,5,6,7,8,8,9};
		int target=8;
		
		System.out.println(test.findFirstTarget(nums, target));
		
		
	}
	
}
