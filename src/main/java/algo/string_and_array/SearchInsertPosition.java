package algo.string_and_array;

public class SearchInsertPosition {
/*
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

你可以假设数组中无重复元素。

示例 1:

输入: [1,3,5,6], 5
输出: 2
示例 2:

输入: [1,3,5,6], 2
输出: 1
示例 3:

输入: [1,3,5,6], 7
输出: 4
示例 4:

输入: [1,3,5,6], 0
输出: 0

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/search-insert-position
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
	
	//use binary search
	public int searchInsert(int[] A, int target) {
		int low = 0, high = A.length-1;
		while(low<=high){
			int mid = (low+high)/2;
			if(A[mid] == target) return mid;
			else if(A[mid] > target) high = mid-1;
			else low = mid+1;
		}
		return low;
	}

	public static void main(String[] args){
		PlusOne test = new PlusOne();

		int[] nums = new int[]{9,1,9};

		int[] res = test.plusOne(nums);

//		ArrayUtil.printArray(res);
	}

}
