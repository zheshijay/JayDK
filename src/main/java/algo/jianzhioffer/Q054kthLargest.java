package algo.jianzhioffer;

/*

给定一棵二叉搜索树，请找出其中第k大的节点。

 

示例 1:

输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 4
示例 2:

输入: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
输出: 4
 

限制：

1 ≤ k ≤ 二叉搜索树元素个数


 */

public class Q054kthLargest {

	int res, k;
	public int kthLargest(TreeNode root, int k) {
		this.k = k;
		dfs(root);
		return res;
	}
	
	public void dfs(TreeNode root) {
		if(root == null) return;
		dfs(root.right);
		if (k-1 == 0) {res = root.val;}
		k--;
		dfs(root.left);
	}
	
//	 int res, k;
//	    public int kthLargest(TreeNode root, int k) {
//	        this.k = k;
//	        dfs(root);
//	        return res;
//	    }
//	    void dfs(TreeNode root) {
//	        if(root == null) return;
//	        dfs(root.right);
//	        if (k-1 == 0) res = root.val;
//	        k--;
//	        dfs(root.left);
//	    }


	/*
	 * 
   3
  / \
 1   4
  \
   2
	 */
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
//		TreeNode n5 = new TreeNode(5);

		n3.left = n1;
		n3.right = n4;
		n1.left = null;
		n1.right = n2;

		Q054kthLargest test = new Q054kthLargest();

		System.out.println("res:" + test.kthLargest(n3, 1));
		
//		int res = test.kthLargest(n1, 1);

//		System.out.println(res);
	}
}