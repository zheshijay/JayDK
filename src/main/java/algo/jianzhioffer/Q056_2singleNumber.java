package algo.jianzhioffer;

import java.util.HashMap;
import java.util.Map;

/*
在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。

示例 1：

输入：nums = [3,4,3,3]
输出：4
示例 2：

输入：nums = [9,1,7,9,7,9,7]
输出：1
*/

public class Q056_2singleNumber {
	public int singleNumber(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			Integer obj = map.get(nums[i]);
			if (obj == null) {
				map.put(nums[i], 1);
			} else if (obj == 1) {
				map.put(nums[i], -1);
			}
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 3, 4, 3, 3 };
		Q056_2singleNumber test = new Q056_2singleNumber();
		System.out.println(test.singleNumber(nums));
	}
}