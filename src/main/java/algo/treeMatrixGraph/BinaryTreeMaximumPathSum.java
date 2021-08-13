package algo.treeMatrixGraph;

/*
 * 
 * 

	二叉树中的最大路径和

 * 
 */

public class BinaryTreeMaximumPathSum {
	 int maxSum = Integer.MIN_VALUE;
	
	public int maxPathSum(TreeNode root) {
		maxPathDown(root);
		return maxSum;
	}

	private int maxPathDown(TreeNode node) {
		if (node == null) return 0;
		int leftGain = Math.max(0, maxPathDown(node.left));
		int rightGain = Math.max(0, maxPathDown(node.right));
		maxSum = Math.max(maxSum, leftGain + rightGain + node.val);
		return Math.max(leftGain, rightGain) + node.val;
	}

	  public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode() {}
		      TreeNode(int val) { this.val = val; }
		      TreeNode(int val, TreeNode left, TreeNode right) {
		          this.val = val;
		          this.left = left;
		         this.right = right;
		      }
		  }

	  public static void main(String[] args) {		 
		  TreeNode node2 = new TreeNode(2);
		  TreeNode node3 = new TreeNode(3);
		  
		  TreeNode node1 = new TreeNode(1, node2, node3);
		  
		  BinaryTreeMaximumPathSum test = new BinaryTreeMaximumPathSum();
		  System.out.println(test.maxPathSum(node1));
	}
}
