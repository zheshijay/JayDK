package algo.btree;


/*
 * 
 * 
For each node like following, there should be four ways existing for max path:

1. Node only
2. L-sub + Node
3. R-sub + Node
4. L-sub + Node + R-sub

Keep trace the four path and pick up the max one in the end.
 * 
 */

public class BinaryTreeMaximumPathSum {

	public int maxPathSum(Node root) {
		int maxValue = Integer.MIN_VALUE;
		maxPathDown(root, maxValue);
		return maxValue;
	}

	private int maxPathDown(Node node, int maxValue) {
		if (node == null) return 0;
		int left = Math.max(0, maxPathDown(node.left, maxValue));
		int right = Math.max(0, maxPathDown(node.right, maxValue));
		maxValue = Math.max(maxValue, left + right + node.val);
		return Math.max(left, right) + node.val;
	}
	
	
	
}
