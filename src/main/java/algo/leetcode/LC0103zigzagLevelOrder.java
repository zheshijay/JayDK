package algo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import algo.jianzhioffer.TreeNode;

public class LC0103zigzagLevelOrder {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root == null) {
			return new ArrayList<List<Integer>>();
		}

		List<List<Integer>> results = new ArrayList<List<Integer>>();

		// add the root element with a delimiter to kick off the BFS loop
		LinkedList<TreeNode> node_queue = new LinkedList<TreeNode>();
		node_queue.addLast(root);
		node_queue.addLast(null);

		LinkedList<Integer> level_list = new LinkedList<Integer>();
		boolean is_order_left = true;

		while (node_queue.size() > 0) {
			TreeNode curr_node = node_queue.pollFirst();
			if (curr_node != null) {
				if (is_order_left)
					level_list.addLast(curr_node.val);
				else
					level_list.addFirst(curr_node.val);

				if (curr_node.left != null)
					node_queue.addLast(curr_node.left);
				if (curr_node.right != null)
					node_queue.addLast(curr_node.right);

			} else {
				// we finish the scan of one level
				results.add(level_list);
				level_list = new LinkedList<Integer>();
				// prepare for the next level
				if (node_queue.size() > 0)
					node_queue.addLast(null);
				is_order_left = !is_order_left;
			}
		}
		return results;
	}

	// Driver code
	public static void main(String args[]) {
		LC0103zigzagLevelOrder test = new LC0103zigzagLevelOrder();
//		int[][] intervals = { { 1, 3 }, { 2, 4 } , { 3, 5 }, { 4, 6 }, { 5, 7 }, { 6, 8 }};
//		int[][] intervals = { { 1, 5 }, { 2, 6 } , { 3, 8 }};
		int[][] intervals = { { 1, 8 }, { 2, 6 }, { 4, 9 } };

		int count = test.eraseOverlapIntervals(intervals);
		System.out.println("count:" + count);
	}
}
