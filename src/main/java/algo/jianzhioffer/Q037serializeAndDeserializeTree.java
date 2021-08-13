package algo.jianzhioffer;

import java.util.LinkedList;
import java.util.Queue;

/*

数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

示例 1:

输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
输出: 2
 

限制：
1 <= 数组长度 <= 50000

 */

public class Q037serializeAndDeserializeTree {
	  public String serialize(TreeNode root) {
	        if(root == null) return "[]";
	        StringBuilder res = new StringBuilder("[");
	        Queue<TreeNode> queue = new LinkedList<>();
	        queue.add(root);
	        while(!queue.isEmpty()) {
	            TreeNode node = queue.poll();
	            if(node != null) {
	                res.append(node.val + ",");
	                queue.add(node.left);
	                queue.add(node.right);
	            }
	            else res.append("null,");
	        }
	        res.deleteCharAt(res.length() - 1);
	        res.append("]");
	        return res.toString();
	    }

	    public TreeNode deserialize(String data) {
	        if(data.equals("[]")) return null;
	        String[] vals = data.substring(1, data.length() - 1).split(",");
	        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
	        Queue<TreeNode> queue = new LinkedList<>();
	        queue.add(root);
	        int i = 1;
	        while(!queue.isEmpty()) {
	            TreeNode node = queue.poll();
	            if(!vals[i].equals("null")) {
	                node.left = new TreeNode(Integer.parseInt(vals[i]));
	                queue.add(node.left);
	            }
	            i++;
	            if(!vals[i].equals("null")) {
	                node.right = new TreeNode(Integer.parseInt(vals[i]));
	                queue.add(node.right);
	            }
	            i++;
	        }
	        return root;
	    }

}