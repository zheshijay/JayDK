package algo.jianzhioffer;

import java.util.LinkedList;
import java.util.Queue;

/*
输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。

示例 1:

给定二叉树 [3,9,20,null,null,15,7]

    3
   / \
  9  20
    /  \
   15   7
返回 true 。

示例 2:

给定二叉树 [1,2,2,3,3,null,null,4,4]

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
返回 false 。

限制：

1 <= 树的结点个数 <= 10000

 */

public class Q055_2isBalanced {

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
	 public boolean isBalanced(TreeNode root) {
	        if (root == null) return true;
	        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
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
		
		Q055_2isBalanced test = new Q055_2isBalanced();

		System.out.println(test.maxDepth(n3));
	}

}