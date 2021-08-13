package algo.jianzhioffer;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNodeUtil {
	
	public static void levelTraversal(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		while(!q.isEmpty()){
			TreeNode cur = q.poll();
			System.out.print(cur.val + " ");
			if (cur.left != null) {
				q.offer(cur.left);
			}
			if (cur.right != null) {
				q.offer(cur.right);
			}
		}
	}

}
