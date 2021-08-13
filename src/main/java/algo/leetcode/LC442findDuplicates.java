package algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC442findDuplicates {
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> res = new ArrayList<>();
		
		for (int i = 0; i < nums.length; ++i) {
			
			int index = Math.abs(nums[i])-1;
			
			if (nums[index] < 0)
				res.add(Math.abs(index+1));
			
			nums[index] = -nums[index];
		}
		return res;
    }

	// Driver code
	public static void main(String args[]) {
		LC442findDuplicates test = new LC442findDuplicates();

		int[] nums = new int[] {4,3,2,7,8,2,3,1};

		List<Integer> res= test.findDuplicates(nums);
		System.out.println("res:" + res);
	}
}
