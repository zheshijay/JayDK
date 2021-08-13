package algo.string_and_array;

import java.util.HashMap;
import java.util.Map;

public class FindSingle {
	/*
	 * 
	 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
	 * 
	 * 说明：
	 * 
	 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
	 * 
	 * 示例 1:
	 * 
	 * 输入: [2,2,1] 输出: 1 示例 2:
	 * 
	 * 输入: [4,1,2,1,2] 输出: 4
	 * 
	 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/single-number
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * 
	 * 
	 */

	// [1,1,2,2,3,4,4]
	// 这个标记法只适用于非负整数
	public int findSingle(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}

		boolean[] status = new boolean[nums.length];

		int i = 0;
		while (i < nums.length) {

			if (status[Math.abs(nums[i])] == true) {
				status[Math.abs(nums[i])] = false;
			} else {
				status[Math.abs(nums[i])] = true;
			}
			i++;
		}

		int j = 0;
		while (j < status.length) {
			if (status[j])
				return j;
			j++;
		}

		return -1;
	}

	public int singleNumber(int[] nums) {
		int ans = 0;
		for (int num : nums) {
			ans ^= num;
		}
		return ans;
	}

	public int singleNumber2(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (Integer i : nums) {
			Integer count = map.get(i);
			count = count == null ? 1 : ++count;
			map.put(i, count);
		}
		for (Integer i : map.keySet()) {
			Integer count = map.get(i);
			if (count == 1) {
				return i;
			}
		}
		return -1; // can't find it.
	}

	public static void main(String[] args) {
		FindSingle test = new FindSingle();

		System.out.println(test.findSingle(new int[] { 1 }));
	}

}
