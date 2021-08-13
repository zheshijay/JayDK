package algo.jianzhioffer;

import java.util.Stack;

/*
请完成一个函数，输入一个二叉树，该函数输出它的镜像。

例如输入：

     4
   /   \
  2     7
 / \   / \
1   3 6   9
镜像输出：

     4
   /   \
  7     2
 / \   / \
9   6 3   1

 

示例 1：

输入：root = [4,2,7,1,3,6,9]
输出：[4,7,2,9,6,3,1]

 */

public class Q028isSymmetric {
	 public boolean isSymmetric(TreeNode root) {
	        return root == null ? true : recur(root.left, root.right);
	    }
	    boolean recur(TreeNode L, TreeNode R) {
	        if(L == null && R == null) return true;
	        if(L == null || R == null || L.val != R.val) return false;
	        return recur(L.left, R.right) && recur(L.right, R.left);
	    }

}