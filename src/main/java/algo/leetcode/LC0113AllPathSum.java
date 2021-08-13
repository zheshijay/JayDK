package algo.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import algo.jianzhioffer.TreeNode;

public class LC0113AllPathSum {
	
	/*
	 * DFS
	 */
	List<List<Integer>> ret = new LinkedList<List<Integer>>();
    Deque<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return ret;
    }

    public void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            ret.add(new LinkedList<Integer>(path));
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
        path.pollLast();
    }
    
    
    /*
     * BFS
     */
    List<List<Integer>> ret = new LinkedList<List<Integer>>();
    Map<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queueNode = new LinkedList<TreeNode>();
        Queue<Integer> queueSum = new LinkedList<Integer>();
        queueNode.offer(root);
        queueSum.offer(0);

        while (!queueNode.isEmpty()) {
            TreeNode node = queueNode.poll();
            int rec = queueSum.poll() + node.val;

            if (node.left == null && node.right == null) {
                if (rec == sum) {
                    getPath(node);
                }
            } else {
                if (node.left != null) {
                    map.put(node.left, node);
                    queueNode.offer(node.left);
                    queueSum.offer(rec);
                }
                if (node.right != null) {
                    map.put(node.right, node);
                    queueNode.offer(node.right);
                    queueSum.offer(rec);
                }
            }
        }

        return ret;
    }
    
    public void getPath(TreeNode node) {
        List<Integer> temp = new LinkedList<Integer>();
        while (node != null) {
            temp.add(node.val);
            node = map.get(node);
        }
        Collections.reverse(temp);
        ret.add(new LinkedList<Integer>(temp));
    }

	// Driver code
	public static void main(String args[]) {
		LC0113AllPathSum test = new LC0113AllPathSum();
//		int[][] intervals = { { 1, 3 }, { 2, 4 } , { 3, 5 }, { 4, 6 }, { 5, 7 }, { 6, 8 }};
//		int[][] intervals = { { 1, 5 }, { 2, 6 } , { 3, 8 }};
		int[][] intervals = { { 1, 8 }, { 2, 6 }, { 4, 9 } };

		int count = test.eraseOverlapIntervals(intervals);
		System.out.println("count:" + count);
	}
}
