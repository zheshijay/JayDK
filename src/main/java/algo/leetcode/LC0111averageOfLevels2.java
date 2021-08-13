package algo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import algo.jianzhioffer.TreeNode;

public class LC0111averageOfLevels2 {
	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> averages = new ArrayList<Double>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			double sum = 0;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				sum += node.val;
				TreeNode left = node.left, right = node.right;
				if (left != null) {
					queue.offer(left);
				}
				if (right != null) {
					queue.offer(right);
				}
			}
			averages.add(sum / size);
		}
		return averages;
	}

	// Driver code
	public static void main(String args[]) {
		LC0111averageOfLevels2 test = new LC0111averageOfLevels2();
//		int[][] intervals = { { 1, 3 }, { 2, 4 } , { 3, 5 }, { 4, 6 }, { 5, 7 }, { 6, 8 }};
//		int[][] intervals = { { 1, 5 }, { 2, 6 } , { 3, 8 }};
		int[][] intervals = { { 1, 8 }, { 2, 6 }, { 4, 9 } };

		int count = test.eraseOverlapIntervals(intervals);
		System.out.println("count:" + count);
	}
}
