package algo.leetcode;

import java.util.LinkedList;
import java.util.Queue;

import algo.jianzhioffer.TreeNode;

public class LC0637averageOfLevels {

	/*
	 * DFS
	 */
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return 1;
		}

		int min_depth = Integer.MAX_VALUE;
		if (root.left != null) {
			min_depth = Math.min(minDepth(root.left), min_depth);
		}
		if (root.right != null) {
			min_depth = Math.min(minDepth(root.right), min_depth);
		}

		return min_depth + 1;
	}
	
	/*
	 * BFS
	 */
	class QueueNode {
        TreeNode node;
        int depth;

        public QueueNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<QueueNode> queue = new LinkedList<QueueNode>();
        queue.offer(new QueueNode(root, 1));
        while (!queue.isEmpty()) {
            QueueNode nodeDepth = queue.poll();
            TreeNode node = nodeDepth.node;
            int depth = nodeDepth.depth;
            if (node.left == null && node.right == null) {
                return depth;
            }
            if (node.left != null) {
                queue.offer(new QueueNode(node.left, depth + 1));
            }
            if (node.right != null) {
                queue.offer(new QueueNode(node.right, depth + 1));
            }
        }

        return 0;
    }

	// Driver code
	public static void main(String args[]) {
		LC0637averageOfLevels test = new LC0637averageOfLevels();
//		int[][] intervals = { { 1, 3 }, { 2, 4 } , { 3, 5 }, { 4, 6 }, { 5, 7 }, { 6, 8 }};
//		int[][] intervals = { { 1, 5 }, { 2, 6 } , { 3, 8 }};
		int[][] intervals = { { 1, 8 }, { 2, 6 }, { 4, 9 } };

		int count = test.eraseOverlapIntervals(intervals);
		System.out.println("count:" + count);
	}
}
