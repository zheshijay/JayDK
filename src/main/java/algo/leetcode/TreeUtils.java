package algo.leetcode;

public class TreeUtils {

	static void printTreeNodeInOrder(TreeNode node) {
		if (node == null) {
			return;
		}
		printTreeNodeInOrder(node.left);
		System.out.print(node.val + " ");
		printTreeNodeInOrder(node.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
