package algo.jianzhioffer;

import java.util.LinkedList;
import java.util.Queue;

/*
输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。

例如：

给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 。

提示：
节点总数 <= 10000

 */

public class Q056_01singleNumbers {

	/*
	 * DFS
	 */
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int lDepth = maxDepth(root.left);
		int rDepth = maxDepth(root.right);
		return Math.max(lDepth, rDepth) + 1;
	}
	
	/*
	 * BFS use queue
	 */
	 public int maxDepth2(TreeNode root) {
		 if (root == null) return 0;
	        Queue<TreeNode> queue = new LinkedList<>();
	        queue.add(root);
	        int res = 0;
	        while (!queue.isEmpty()) {
	            res++;
	            int n = queue.size();
	            for (int i = 0; i < n; i++) {
	                TreeNode node = queue.poll();
	                if (node.left != null) queue.add(node.left);
	                if (node.right != null) queue.add(node.right);
	            }
	        }
	        return res;
	 }

	public static void main(String[] args) {
		TreeNode n3 = new TreeNode(3);
		TreeNode n9 = new TreeNode(9);
		TreeNode n20 = new TreeNode(20);
		TreeNode n15 = new TreeNode(15);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		
		n3.left = n9;
		n3.right = n20;
		n20.left = n15;
		n20.right = n7;
		n7.left = n8;
		
		Q056_01singleNumbers test = new Q056_01singleNumbers();

		System.out.println(test.maxDepth(n3));
	}

}