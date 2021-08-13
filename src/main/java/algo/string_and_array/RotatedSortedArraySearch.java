package algo.string_and_array;

public class RotatedSortedArraySearch {

	/*
给你一个升序排列的整数数组 nums ，和一个整数 target 。

假设按照升序排序的数组在预先未知的某个点上进行了旋转。（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] ）。

请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

 
示例 1：

输入：nums = [4,5,6,7,0,1,2], target = 0
输出：4
示例 2：

输入：nums = [4,5,6,7,0,1,2], target = 3
输出：-1
示例 3：

输入：nums = [1], target = 0
输出：-1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static int search(int[] nums, int target) {

		if(nums == null || nums.length<1) return -1;
		if(nums.length==1){
			if(nums[0] == target) return 0;
			else return -1;
			
		}

		//find shift ( find the 1st element less the the first element of the array )
		int shiftIndex = 0;
		for(int i=0; i < nums.length-1; i++){
			if(nums[i] > nums[i+1]){
				shiftIndex = i;
				break;
			}
		}

		System.out.print("shiftIndex: " + shiftIndex + 1);

		// low ~ shiftIndex,   shiftIndex ~ ( nums.length - 1)
		int low1 = 0;
		int high1 = shiftIndex+1;
		int mid1 = ( low1 + high1)/2;
		while(low1<=high1){

			

			if(nums[mid1] == target) return mid1;

			if(nums[mid1] < target) 
				low1 = mid1 + 1;

			if(nums[mid1] > target) 
				high1 = mid1 - 1;

			mid1 = ( low1 + high1) /2;
		}
		
		int low2 = shiftIndex+1;
		int high2 = nums.length - 1;
		int mid2 = ( low2 + high2 )/2;
		
		System.out.println("\n search 2nd half, low " + low2 + " high: " + high2);
		
		while(low2 <= high2){
			if(nums[mid2] == target) return mid2;

			if(nums[mid2] < target) 
				low2 = mid2 + 1;
			if(nums[mid2] > target) 
				high2 = mid2 - 1;

			mid2 = ( low2 + high2) /2;
		}

		return -1;

	}
	
	
	  public int search2(int[] nums, int target) {
	        int n = nums.length;
	        if (n == 0) {
	            return -1;
	        }
	        if (n == 1) {
	            return nums[0] == target ? 0 : -1;
	        }
	        int l = 0, r = n - 1;
	        while (l <= r) {
	            int mid = (l + r) / 2;
	            if (nums[mid] == target) {
	                return mid;
	            }
	            if (nums[0] <= nums[mid]) {
	                if (nums[0] <= target && target < nums[mid]) {
	                    r = mid - 1;
	                } else {
	                    l = mid + 1;
	                }
	            } else {
	                if (nums[mid] < target && target <= nums[n - 1]) {
	                    l = mid + 1;
	                } else {
	                    r = mid - 1;
	                }
	            }
	        }
	        return -1;
	    }


	public static void main(String[] args) {

		int[] nums = {4,5,6,7,0,1,2};
		System.out.println(RotatedSortedArraySearch.search(nums, 3));
	}
}
