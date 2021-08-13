package algo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import algo.jianzhioffer.TreeNode;

public class LC0207levelOrderBottom {
	 public List<List<Integer>> levelOrderBottom(TreeNode root) {
	        List<List<Integer>> levelOrder = new LinkedList<List<Integer>>();
	        if (root == null) {
	            return levelOrder;
	        }
	        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        queue.offer(root);
	        while (!queue.isEmpty()) {
	            List<Integer> level = new ArrayList<Integer>();
	            int size = queue.size();
	            for (int i = 0; i < size; i++) {
	                TreeNode node = queue.poll();
	                level.add(node.val);
	                TreeNode left = node.left, right = node.right;
	                if (left != null) {
	                    queue.offer(left);
	                }
	                if (right != null) {
	                    queue.offer(right);
	                }
	            }
	            levelOrder.add(0, level);
	            
	        }
	        return levelOrder;
	    }
	
	// Driver code
	public static void main(String args[]) {
		LC0207levelOrderBottom test = new LC0207levelOrderBottom();
//		int[][] intervals = { { 1, 3 }, { 2, 4 } , { 3, 5 }, { 4, 6 }, { 5, 7 }, { 6, 8 }};
//		int[][] intervals = { { 1, 5 }, { 2, 6 } , { 3, 8 }};
		int[][] intervals = { { 1, 8 }, { 2, 6 } , { 4, 9 }};

		int count= test.eraseOverlapIntervals(intervals);
		System.out.println("count:" + count);
	}
}
