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

public class Q027mirrorTree {
	/*
	 * Solution 1: Recursion
	 * 
	 */
	 public TreeNode mirrorTree(TreeNode root) {
		 	if (root == null) return root;
		 
	        if (root.left != null || root.right != null) {
	        	mirrorTree(root.left);
	        	mirrorTree(root.right);
	        	swap(root);
	        }
	        return root;
	    }
	
	private void swap(TreeNode root) {
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
	}
	
	/*
	 * Solution 2: Recursion 2
	 * 
	 */
	  public TreeNode mirrorTree2(TreeNode root) {
	        if(root == null) return null;
	        TreeNode tmp = root.left;
	        root.left = mirrorTree2(root.right);
	        root.right = mirrorTree2(tmp);
	        return root;
	    }

	
	/*
	 * Solution 3: use Stack
	 * 
	 * 
	 */
	public TreeNode mirrorTree3(TreeNode root) {
        if(root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.left != null) stack.add(node.left);
            if(node.right != null) stack.add(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }


	public static void main(String[] args) {
		TreeNode n4 = new TreeNode(4);
		TreeNode n2 = new TreeNode(2);
		TreeNode n7 = new TreeNode(7);
		TreeNode n1 = new TreeNode(1);
		TreeNode n3 = new TreeNode(3);
		TreeNode n6 = new TreeNode(6);
		TreeNode n9 = new TreeNode(9);
		
		n4.left = n2;
		n4.right = n7;
		n2.left = n1;
		n2.right = n3;
		n7.left = n6;
		n7.right = n9;
		
		
		
		Q027mirrorTree test = new Q027mirrorTree();
		
		TreeNodeUtil util = new TreeNodeUtil();
		util.levelTraversal(n4);
		TreeNode newNode = test.mirrorTree(n4);
		System.out.println();
		util.levelTraversal(n4);
//		System.out.println(test.reverseLeftWords5(s, 2));
	}

}