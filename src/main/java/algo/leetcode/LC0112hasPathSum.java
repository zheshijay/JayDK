package algo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import algo.jianzhioffer.TreeNode;

public class LC0112hasPathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queNode = new LinkedList<TreeNode>();
        Queue<Integer> queVal = new LinkedList<Integer>();
        queNode.offer(root);
        queVal.offer(root.val);
        while (!queNode.isEmpty()) {
            TreeNode now = queNode.poll();
            int temp = queVal.poll();
            if (now.left == null && now.right == null) {
                if (temp == sum) {
                    return true;
                }
                continue;
            }
            if (now.left != null) {
                queNode.offer(now.left);
                queVal.offer(now.left.val + temp);
            }
            if (now.right != null) {
                queNode.offer(now.right);
                queVal.offer(now.right.val + temp);
            }
        }
        return false;
    }

	// Driver code
	public static void main(String args[]) {
		LC0112hasPathSum test = new LC0112hasPathSum();
//		int[][] intervals = { { 1, 3 }, { 2, 4 } , { 3, 5 }, { 4, 6 }, { 5, 7 }, { 6, 8 }};
//		int[][] intervals = { { 1, 5 }, { 2, 6 } , { 3, 8 }};
		int[][] intervals = { { 1, 8 }, { 2, 6 }, { 4, 9 } };

		int count = test.eraseOverlapIntervals(intervals);
		System.out.println("count:" + count);
	}
}
