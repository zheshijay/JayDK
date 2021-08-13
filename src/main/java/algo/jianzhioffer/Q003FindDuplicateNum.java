package algo.jianzhioffer;

import java.util.HashSet;
import java.util.Set;

public class Q003FindDuplicateNum {
	/*
	 * 
	 * 题目描述 找出数组中重复的数字。
	 * 
	 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
	 * 数组中某些数字是重复的，但不知道有几个数字是重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。例如，如果输入长度为 7 的数组 {2,
	 * 3, 1, 0, 2, 5, 3}，那么对应的输出是第一个重复的数字 2 或 3 。
	 */

	public int findDuplicateNum(int[] nums) {
		if (nums.length < 1) {
			return -1;
		}

		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				return nums[i];
			}
			set.add(nums[i]);
		}

		return -1;

	}
	
	//原地置换
	public int findRepeatNumber2(int[] nums) {
        int temp;
        for(int i=0;i<nums.length;i++){
            while (nums[i]!=i){
                if(nums[i]==nums[nums[i]]){
                    return nums[i];
                }
                temp=nums[i];
                nums[i]=nums[temp];
                nums[temp]=temp;
            }
        }
        return -1;
    }

	
	public static void main(String[] args) {
		Q003FindDuplicateNum test = new Q003FindDuplicateNum();
		
		int[] nums = new int[] {2, 3, 1, 0, 2, 5, 3};
		
		System.out.println(test.findDuplicateNum(nums));
	}
}
