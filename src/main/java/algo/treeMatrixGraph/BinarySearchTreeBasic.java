package algo.treeMatrixGraph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import algo.jianzhioffer.TreeNode;

import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class BinarySearchTreeBasic {
	
	 // delete node in BST
	 public TreeNode deleteNode(TreeNode node, int target) {
		 if (node == null) return null;

		 if (target < node.val) {
			 node.left = deleteNode(node.left, target);
		 } else	if (target > node.val) {
			 node.right = deleteNode(node.right, target);
		 } else {
			 if (node.left == null && node.right == null) {
				 node = null;
			 } else if (node.left != null) {
				 // find the max from left (predecessor)
				 node.val = predecessor(node);
				 node.left = deleteNode(node.left, node.val);
			 } else {
				 // find the min from right (successor)
				 node.val = successor(node);
				 node.right = deleteNode(node.right, node.val);
			 }
		 }
		 return node;
	 }
	 
	 // the max on left subtree
	 private int predecessor(TreeNode node) {
		 node = node.left;
		 while(node.right != null) {
			 node = node.right;
		 }
		 return node.val;
	 }
	 
	// the min on right subtree
	 private int successor(TreeNode node) {
		node = node.right;
		while(node.left != null) {
			 node = node.left;
		}
		return node.val;
	}
	 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

/*
    5
   / \
  3   6
 / \   \
2   4   7

*/

		TreeNode Node5 = new TreeNode(5);
		TreeNode Node3 = new TreeNode(3);
		TreeNode Node6 = new TreeNode(6);
		TreeNode Node2 = new TreeNode(2);
		TreeNode Node4 = new TreeNode(4);
		TreeNode Node7 = new TreeNode(7);

		Node5.left = Node3;
		Node5.right = Node6;
		Node3.left = Node2;
		Node3.right = Node4;
		Node6.right = Node7;

		TreeNode node = Node5;

		BinarySearchTreeBasic test = new BinarySearchTreeBasic();
		
		test.deleteNode(node, 3);


	}

}
