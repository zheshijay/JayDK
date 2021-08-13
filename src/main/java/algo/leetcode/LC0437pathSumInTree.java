package algo.leetcode;

import java.util.HashMap;

import algo.jianzhioffer.TreeNode;

public class LC0437pathSumInTree {
//	  public int pathSum(TreeNode root, int sum) {
//	        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//	        map.put(0, 1);
//	        return helper(root, map, sum, 0);
//	    }
//	    
//	    int helper(TreeNode root, HashMap<Integer, Integer> map, int sum, int pathSum){
//	        int res = 0;
//	        if(root == null) return 0;
//	        
//	        pathSum += root.val;
//	        res += map.getOrDefault(pathSum - sum, 0);
//	        map.put(pathSum, map.getOrDefault(pathSum, 0) + 1);
//	        System.out.println("root:" + root.val + "   |   map:" + map);
//	        res = helper(root.left, map, sum, pathSum) + helper(root.right, map, sum, pathSum) + res;
//	        map.put(pathSum, map.get(pathSum) - 1);
//	        return res;
//	    }

	public int pathSum(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}
		int result = countPath(root, sum);
		int a = pathSum(root.left, sum);
		int b = pathSum(root.right, sum);
		return result + a + b;

	}

	public int countPath(TreeNode root, int sum) {	
		if (root == null) {
			return 0;
		}
		
		
		sum = sum - root.val;
		int result = sum == 0 ? 1 : 0;
		
		System.out.println("countPath: root:" + root.val + "|sum:" + sum + "|res:" + result);
		return result + countPath(root.left, sum) + countPath(root.right, sum);
	}

	// Driver code
	public static void main(String args[]) {
		TreeNode n10 = new TreeNode(10);
		TreeNode n5 = new TreeNode(5);
		TreeNode nn3 = new TreeNode(-3);
		TreeNode n3 = new TreeNode(3);
		TreeNode n2 = new TreeNode(2);
		TreeNode n11 = new TreeNode(11);
		TreeNode n3a = new TreeNode(3);
		TreeNode nn2 = new TreeNode(-2);
		TreeNode n1 = new TreeNode(1);

		n10.left = n5;
		n10.right = nn3;
		n5.left = n3;
		n5.right = n2;
		nn3.right = n11;
		n3.left = n3a;
		n3.right = nn2;
		n2.right = n1;

		LC0437pathSumInTree test = new LC0437pathSumInTree();
		int count = test.pathSum(n10, 8);

		System.out.println(count);

//		printKMax(arr, arr.length, k);
//		printMax(arr, arr.length, k);
	}
}
