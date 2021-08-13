package algo.jianzhioffer;

import java.util.List;
import java.util.Stack;

/*

从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。

 */

public class Q033verifyPostorder {
//1,3,2,6,5

	public boolean verifyPostorder(int[] postorder) {
		return recur(postorder, 0, postorder.length - 1);
	}

	boolean recur(int[] postorder, int i, int j) {
		if (i >= j)
			return true;
		int p = i;
		while (postorder[p] < postorder[j])
			p++;
		int m = p;
		while (postorder[p] > postorder[j])
			p++;
		return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
	}

	boolean verifyOrder2(int[] nums) {
		return isBst(nums, 0, nums.length -1); 
	}

	private boolean isBst(int[] nums, int i, int j) {
		if (i >= j) {return true;}
		
		// Check left tree
		int p = i;
		while(nums[p] < nums[j]) p++;
		
		// Check right tree
		int m = p;
		while(nums[p] > nums[j]) p++;
		
		return (p == j && isBst(nums, i, m -1) && isBst(nums, m, j-1) );
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 3, 2, 6, 5 };

		Q033verifyPostorder test = new Q033verifyPostorder();
		System.out.println(test.verifyOrder2(nums));

	}

}