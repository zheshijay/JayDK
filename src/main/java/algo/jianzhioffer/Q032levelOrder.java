package algo.jianzhioffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*

从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。

 */

public class Q032levelOrder {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();

		if (root != null)
			queue.add(root);

		while (!queue.isEmpty()) {
			List<Integer> temp = new ArrayList<>();
			for (int i = queue.size(); i > 0; i--) {
				TreeNode node = queue.poll();
				temp.add(node.val);

				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			if (res.size() % 2 == 1)
				Collections.reverse(temp);
			System.out.println("adding :" + temp);

			res.add(temp);
		}
		return res;
	}

	public static void main(String[] args) {
		TreeNode n3 = new TreeNode(3);
		TreeNode n9 = new TreeNode(9);
		TreeNode n20 = new TreeNode(20);
		TreeNode n15 = new TreeNode(15);
		TreeNode n7 = new TreeNode(7);

		n3.left = n9;
		n3.right = n20;
		n20.left = n15;
		n20.right = n7;

		Q032levelOrder test = new Q032levelOrder();
		List<List<Integer>> res = test.levelOrder(n3);
		System.out.println(res);
	}

}