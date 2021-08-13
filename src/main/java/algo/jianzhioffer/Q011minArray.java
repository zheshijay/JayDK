package algo.jianzhioffer;

import java.util.HashSet;
import java.util.Set;

/*
输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。

示例 1:

输入: n = 1
输出: [1,2,3,4,5,6,7,8,9]

说明：

用返回一个整数列表来代替打印
n 为正整数

 */

public class Q011minArray {
	public boolean isStraight(int[] nums) {
		Set<Integer> repeat = new HashSet<>();
		int max = 0, min = 14;
		for (int num : nums) {
			if (num == 0)
				continue; // 跳过大小王
			max = Math.max(max, num); // 最大牌
			min = Math.min(min, num); // 最小牌
			if (repeat.contains(num))
				return false; // 若有重复，提前返回 false
			repeat.add(num); // 添加此牌至 Set
		}
		return max - min < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
	}

	public static void main(String[] args) {

		Q011minArray test = new Q011minArray();
		int[] nums = new int[] { 2, 0, 5, 0, 1 };
		System.out.println(test.isStraight(nums));

	}

}