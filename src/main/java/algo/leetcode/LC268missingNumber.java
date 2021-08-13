package algo.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC268missingNumber {
	public int missingNumber(int[] nums) {
		Set<Integer> numSet = new HashSet<Integer>();
		for (int num : nums)
			numSet.add(num);

		int expectedNumCount = nums.length + 1;
		for (int number = 0; number < expectedNumCount; number++) {
			if (!numSet.contains(number)) {
				return number;
			}
		}
		return -1;
	}

	// Driver code
	public static void main(String args[]) {
		LC268missingNumber test = new LC268missingNumber();

		int[] nums = new int[] { 3, 0, 1 };

		List<Integer> res = test.findDuplicates(nums);
		System.out.println("res:" + res);
	}
}
