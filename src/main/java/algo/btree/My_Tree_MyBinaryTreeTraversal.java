package algo.btree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class My_Tree_MyBinaryTreeTraversal {

	static class Node{
		int val;
		Node left;
		Node right;

		Node(int val){
			this.val = val;
			left= null;
			right = null;
		}
	}


	private void preOrder(Node root) {
		if(root == null) return;
		System.out.print(root.val);
		preOrder(root.left);
		preOrder(root.right);
	}

	private void inOrder(Node root) {
		if(root == null) return;
		inOrder(root.left);
		System.out.print(root.val);
		inOrder(root.right);
	}


	private void postOrder(Node root) {
		if(root == null) return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.val);
	}


	private void levelTraversal(Node node) {

		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(node);
		int inCount = 1;
		int outCount = 0;

		while(!queue.isEmpty()){
			Node curNode = queue.poll();
			System.out.print(curNode.val);
			outCount++;

			//add child to queue
			if(curNode.left!=null)	queue.offer(curNode.left);
			if(curNode.right!=null)	queue.offer(curNode.right);

			if(inCount == outCount) {
				System.out.println();  
				inCount = queue.size();  
				outCount = 0;  
			}

		}


	}


	private void findLCA(Node root) {


	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* 
		        __1__ 
		       /     \ 
		    __2__     3__ 
		   /     \       \ 
		  4     __5__     6 
		       7     8 
		 */  

		Node Node1 = new Node(1);
		Node Node2 = new Node(2);
		Node Node3 = new Node(3);
		Node Node4 = new Node(4);
		Node Node5 = new Node(5);
		Node Node6 = new Node(6);
		Node Node7 = new Node(7);
		Node Node8 = new Node(8);

		Node1.left = Node2;
		Node1.right = Node3;
		Node2.left = Node4;
		Node2.right = Node5;
		Node3.right = Node6;
		Node5.left = Node7;
		Node5.right = Node8;

		Node root = Node1;

		My_Tree_MyBinaryTreeTraversal tt = new My_Tree_MyBinaryTreeTraversal();

		System.out.println("preOrder: ");  
		tt.preOrder(root);
		//
		//		System.out.println();
		//
		System.out.println("inOrder: ");  
		tt.inOrder(root);
		//
		//		System.out.println();
		//
		System.out.println("postOrder: ");  
		tt.postOrder(root);
		//
		System.out.println("levelTraversal: ");  
		tt.levelTraversal(root);
		//
		//
		//		System.out.println("traverseByLevelFromTop: ");  
		//		tt.traverseByLevelFromTop(root);
		//
		//		System.out.println();
		//
		//		System.out.println("traverseByLevelFromBottom: ");  
		//		tt.traverseByLevelFromBottom(root);
		//
		//		System.out.println();
		//
		//		System.out.println("findLCA: ");  
		//		Node lca = tt.findLCA(root,Node4, Node6);
		//		System.out.println("lca: " + lca.val);
		//		//
		//		System.out.println();
		//
		//		System.out.println("search Node: ");  
		//		Node found = tt.search(root, 11);
		//		if(found!=null) System.out.println("found: " + found.val);
		//		else{ System.out.println("Not found"); }
		//
		//
		//		System.out.println();
		//
		//		System.out.println("Mirro:");
		//		
		//		System.out.println("before: "+root.left.val);
		//		tt.mirror(root);
		//		System.out.println("after: "+root.left.val);


		System.out.println();

		System.out.println("DFS:");
		//		tt.depthOrderTraversal(root);

		System.out.println("BFS:");
		//		tt.levelOrderTraversal(root);

	}
}
