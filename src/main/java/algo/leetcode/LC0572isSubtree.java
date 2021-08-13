package algo.leetcode;

import java.util.LinkedList;
import java.util.Queue;

import algo.jianzhioffer.TreeNode;

public class LC0572isSubtree {
	 public boolean isSubtree(TreeNode s, TreeNode t) {
	        String s1 = serialize(s);
	        String s2 = serialize(t);
	        return s1.contains(s2);
	    }

	 private static String serialize(TreeNode node) {
	        if (null == node) {
	            return "_";
	        }
	        String res = "|" + node.val + "|";
//	        String res = Integer.toString(node.val);
	        res += serialize(node.left);
	        res += serialize(node.right);
	        return res;
	    }
    
    public static void main(String[] args) {
    	TreeNode nodeA = new TreeNode(12);
//    	TreeNode nodeB = new TreeNode(2);
//    	TreeNode nodeC = new TreeNode(3);
//    	TreeNode nodeD = new TreeNode(4);
//    	TreeNode nodeE = new TreeNode(5);
    	
//    	nodeA.left = nodeB;
//    	nodeC.left = nodeD;
//    	nodeC.right = nodeE;
//    	nodeD.left = nodeA;
//    	nodeD.right = nodeB;
    	
//    	TreeNode nodeF = new TreeNode(4);
//    	TreeNode nodeG = new TreeNode(1);
    	TreeNode nodeH = new TreeNode(2);
    	
//    	nodeF.left = nodeG;
//    	nodeF.right = nodeH;
    	
    	
    	
    	LC0572isSubtree test = new LC0572isSubtree();
//    	String s1 = test.serialize(nodeA);
//    	String s2 = test.serialize(nodeH);
//    	
//    	System.out.println("s1:" + s1);
//    	System.out.println("s2:" + s2);
    	
    	boolean res = test.isSubtree(nodeA, nodeH);
    	
    	
    	System.out.println("res:" + res);
	}
}
