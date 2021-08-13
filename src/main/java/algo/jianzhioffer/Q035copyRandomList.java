package algo.jianzhioffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*

数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

示例 1:

输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
输出: 2
 

限制：
1 <= 数组长度 <= 50000

 */

public class Q035copyRandomList {

	/*
	 * 哈希表统计法： 遍历数组 nums ，用 HashMap 统计各数字的数量，即可找出 众数 。此方法时间和空间复杂度均为 O(N)O(N) 。
	 */
	public int majorityElement1(int[] nums) {

		return -1;
	}

	/*
	 * 数组排序法： 将数组 nums 排序，数组中点的元素 一定为众数。
	 */
	 public int majorityElement2(int[] nums) {

		return -1;
	}

	/*
	 * 摩尔投票法： 核心理念为 票数正负抵消 。此方法时间和空间复杂度分别为 O(N)O(N) 和 O(1)O(1) ，为本题的最佳解法。
	 */
	 public int majorityElement(int[] nums) {
	        int x = 0, votes = 0;
	        for(int num : nums){
	            if(votes == 0) x = num;
	            votes += num == x ? 1 : -1;
	        }
	        return x;
	    }


	public static void main(String[] args) {
		TreeNode n3 = new TreeNode(3);
		TreeNode n9 = new TreeNode(9);
		TreeNode n20 = new TreeNode(20);
		TreeNode n15 = new TreeNode(15);
		TreeNode n7 = new TreeNode(7);

		n3.left = n9;
		n3.right = n20;
		n20.left = n15;
		n20.right = n7;

		Q035copyRandomList test = new Q035copyRandomList();
		List<List<Integer>> res = test.levelOrder(n3);
		System.out.println(res);
	}

}