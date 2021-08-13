package algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import algo.jianzhioffer.TreeNode;

public class LC0652findDuplicateSubtrees {
	
	 	Map<String, Integer> count;
	    List<TreeNode> ans;
	    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
	        count = new HashMap();
	        ans = new ArrayList();
	        collect(root);
	        return ans;
	    }

	    public String collect(TreeNode node) {
	        if (node == null) return null;
	        String serial = node.val + "," + collect(node.left) + "," + collect(node.right);
	        
	        System.out.println("Add serial:" + serial);
	        
	        count.put(serial, count.getOrDefault(serial, 0) + 1);
	        if (count.get(serial) == 2)
	            ans.add(node);
	        return serial;
	    }

	public static void main(String[] args) {
		LC0652findDuplicateSubtrees test = new LC0652findDuplicateSubtrees();
		
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node2a = new TreeNode(2);
		TreeNode node4a = new TreeNode(4);
		TreeNode node4b = new TreeNode(4);
		
		node1.left = node2;
		node2.left = node4;
		node1.right = node3;
		node3.left=node2a;
		node2a.left = node4a;
		node3.right=node4b;
		
		List<TreeNode> ans = test.findDuplicateSubtrees(node1);


	}

}
