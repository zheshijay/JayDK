package algo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import algo.jianzhioffer.TreeNode;

public class LC0102levelOrder {
	 public List<List<Integer>> levelOrder(TreeNode root) {
		 	LinkedList<List<Integer>> ret = new LinkedList<List<Integer>>();
	        if (root == null) {
	            return ret;
	        }

	        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        queue.offer(root);
	        while (!queue.isEmpty()) {
	            List<Integer> level = new ArrayList<Integer>();
	            int currentLevelSize = queue.size();
	            for (int i = 1; i <= currentLevelSize; ++i) {
	                TreeNode node = queue.poll();
	                level.add(node.val);
	                if (node.left != null) {
	                    queue.offer(node.left);
	                }
	                if (node.right != null) {
	                    queue.offer(node.right);
	                }
	            }
	            ret.add(level);
	        }
	        
	        return ret;
	    }

	// Driver code
	public static void main(String args[]) {
		
	}
}
