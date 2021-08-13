package algo.jianzhioffer;

import java.util.ArrayList;

/*
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]


 */

public class Q062_2lastRemaining {

	 public int lastRemaining(int n, int m) {
	        ArrayList<Integer> list = new ArrayList<>(n);
	        for (int i = 0; i < n; i++) {
	            list.add(i);
	        }
	        int idx = 0;
	        while (n > 1) {
	            idx = (idx + m - 1) % n;
	            list.remove(idx);
	            n--;
	        }
	        return list.get(0);
	    }

	public static void main(String[] args) {

		Q062_2lastRemaining test = new Q062_2lastRemaining();

		TreeNode n0 = new TreeNode(0);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);

		n3.left = n5;
		n3.right = n1;
		n5.left = n6;
		n5.right = n2;
		n2.left = n7;
		n2.right = n4;
		n1.left = n0;
		n1.right = n8;

		TreeNode lca = test.lowestCommonAncestor(n3, n5, n1);

		System.out.println(lca.val);
	}

}