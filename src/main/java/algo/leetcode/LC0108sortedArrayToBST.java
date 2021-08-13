package algo.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC0108sortedArrayToBST {
	public TreeNode sortedArrayToBST(int[] nums) {
		return helper(nums, 0, nums.length - 1);
	}

	public TreeNode helper(int[] nums, int left, int right) {
		if (left > right) {
			return null;
		}

		// 总是选择中间位置右边的数字作为根节点
		int mid = (left + right + 1) / 2;

		TreeNode root = new TreeNode(nums[mid]);
		root.left = helper(nums, left, mid - 1);
		root.right = helper(nums, mid + 1, right);
		return root;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {-10, -3, 0, 5, 9};
		
		LC0108sortedArrayToBST test = new LC0108sortedArrayToBST();
		TreeNode res = test.sortedArrayToBST(nums);
		TreeUtils.printTreeNodeInOrder(res);
		
	}
	
	
}
