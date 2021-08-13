package algo.binary_search;

public class FindLastTarget {
	
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
	

	public static void main(String[] args){
		
		
		FindLastTarget test = new FindLastTarget();
		
		int[] nums = new int[]{1,1,2,2,3,4,4};
		int target=4;
		
		System.out.println(test.findLastTarget(nums, target));
		
		
	}
	
}
