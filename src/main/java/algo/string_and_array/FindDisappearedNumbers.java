package algo.string_and_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode Find All Numbers Disappeared in an Array
 * 
给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。

找到所有在 [1, n] 范围之间没有出现在数组中的数字。

您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。

示例:

输入:
[4,3,2,7,8,2,3,1]

输出:
[5,6]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

/*
 * 
Solutions1: from leetcode

use 2 for loop:
 first loop: mark appeared index to negitive value
 second loop: find the indices which has postive value 


My solution: I think it is the best



 * 
 */

public class FindDisappearedNumbers {
	public List<Integer> findDisappearedNumbers(int[] nums) {  
		List<Integer> ret = new ArrayList<Integer>();

		for(int i = 0; i < nums.length; i++) {
			int val = Math.abs(nums[i])  - 1;
			if(nums[val] > 0) {
				nums[val] = -nums[val];
			}
		}

		for(int i = 0; i < nums.length; i++) {
			if(nums[i] > 0) {
				ret.add(i+1);
			}
		}
		return ret;
	}

	
	//practice
	 public List<Integer> myFindDisappearedNumbers(int[] nums)
	    {
	        List<Integer> res = new ArrayList<Integer>();
	        
	    	boolean[] appeardIndices = new boolean[nums.length];

	    	
	    	for(int i=0; i<nums.length; i++){
	    		if(!appeardIndices[nums[i] - 1]){
	    			appeardIndices[nums[i] - 1] = true;
	    		}
	    	}
	    	
	    	for(int j=0; j<appeardIndices.length; j++){
	    		if(!appeardIndices[j]) res.add(j+1);
	    	}

	        return res;
	    }
	
	public static void main(String args[]){
		FindDisappearedNumbers test = new FindDisappearedNumbers();
		
		int[] nums = new int[]{4,3,2,7,8,2,3,1};

		List<Integer> res = test.findDisappearedNumbers(nums);
		
		System.out.println(res);
	}

}
