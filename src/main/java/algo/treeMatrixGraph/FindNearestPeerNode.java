package algo.treeMatrixGraph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.tree.Tree.Node;
import com.tree.Tree.NodeVisitor;

public class FindNearestPeerNode{

	public TreeNode findNeartestRightNode(TreeNode root, TreeNode u) {

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                TreeNode cur = q.poll();
                if (cur == u)
                    return i < size - 1 ? q.poll() : null;
                if (null != cur.left) q.offer(cur.left);
                if (null != cur.right) q.offer(cur.right);
            }
        }
        
        return null;
    }

}
