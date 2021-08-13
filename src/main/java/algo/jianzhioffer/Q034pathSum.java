package algo.jianzhioffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*

输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。

示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:

[
   [5,4,11,2],
   [5,8,4,5]
]

提示：
节点总数 <= 10000

 */

public class Q034pathSum {

//	List<List<Integer>> res = new ArrayList<>();
//	List<Integer> path = new ArrayList<>();
//	
//	public List<List<Integer>> pathSum(TreeNode root, int target) {
//		
//		dfs(root, 0, path, target);
//		
//		return res;
//	}
//
//	void dfs (TreeNode root, int sum, List<Integer> path, int target){
//		
//			if (root == null) {return;}
//			
//			path.add(root.val);
//			sum += root.val;
//			
//			if (root.left == null && root.right == null && sum == target) {
//				System.out.println("Adding :" + path);
//				res.add(new ArrayList<>(path));
//				return;
//			}
//			
//	        dfs(root.left, sum, path, target);
//	        dfs(root.right, sum, path, target);
//	        
//	        // restore
//	        path.remove(path.size() -1);
//	    }
	
	LinkedList<List<Integer>> res = new LinkedList<>();
	LinkedList<Integer> path = new LinkedList<>();

	public List<List<Integer>> pathSum(TreeNode root, int target) {
		recur(root, target);
		return res;
	}

	void recur(TreeNode root, int tar) {
		if (root == null)
			return;
		path.add(root.val);
		tar -= root.val;
		if (tar == 0 && root.left == null && root.right == null)
			res.add(new LinkedList<>(path));
		recur(root.left, tar);
		recur(root.right, tar);
		path.removeLast();
	}

	// Solution 2
//	LinkedList<List<Integer>> res = new LinkedList<>();
//	LinkedList<Integer> path = new LinkedList<>();
//
//	public List<List<Integer>> pathSum(TreeNode root, int sum) {
//		recur(root, sum);
//		return res;
//	}
//
//	void recur(TreeNode root, int tar) {
//		if (root == null)
//			return;
//		path.add(root.val);
//		tar -= root.val;
//		if (tar == 0 && root.left == null && root.right == null)
//			res.add(new LinkedList<>(path));
//		recur(root.left, tar);
//		recur(root.right, tar);
//		path.removeLast();
//	}

	public static void main(String[] args) {
		TreeNode n5 = new TreeNode(5);
		TreeNode n4 = new TreeNode(4);
		TreeNode n8 = new TreeNode(8);
		TreeNode n11 = new TreeNode(11);
		TreeNode n13 = new TreeNode(13);
		TreeNode n4_2 = new TreeNode(4);
		TreeNode n7 = new TreeNode(7);
		TreeNode n2 = new TreeNode(2);
		TreeNode n5_2 = new TreeNode(5);
		TreeNode n1 = new TreeNode(1);

		n5.left = n4;
		n5.right = n8;
		n4.left = n11;
		n8.left = n13;
		n8.right = n4_2;

		n11.left = n7;
		n11.right = n2;

		n4_2.left = n5_2;
		n4_2.right = n1;

		Q034pathSum test = new Q034pathSum();
		List<List<Integer>> res = test.pathSum(n5, 22);
		System.out.println(res);
	}

}