package algo.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。

请找出其中最小的元素。

 

示例 1：

输入：nums = [3,4,5,1,2]
输出：1
示例 2：

输入：nums = [4,5,6,7,0,1,2]
输出：0
示例 3：

输入：nums = [1]
输出：1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC0153FindMinimuminRotatedSortedArray {
	  public int findMin(int[] nums) {
			int start=0, end=nums.length-1;
			int target = nums[end];
			while(start+1 < end){
				int mid = (start+end)/2;

				if(target > nums[mid]) end=mid;
				else start=mid;
			}

			if(nums[start] <=target){
				return nums[start];
			} else return nums[end];

	    }
}
