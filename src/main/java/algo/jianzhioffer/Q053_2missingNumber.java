package algo.jianzhioffer;

/*
输入两个链表，找出它们的第一个公共节点。
 */

public class Q053_2missingNumber {

	 public int missingNumber(int[] nums) {
	        int left = 0,right = nums.length;
	        while(left < right){
	            int mid = (left + right)/2;
	            if(nums[mid] == mid) {
	                left = mid +1;
	            }else if(nums[mid] > mid){
	                right = mid;
	            }
	        }
	        return left;
	    }
	 
}