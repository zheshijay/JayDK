package algo.btree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Tree_MyBinaryTreeTraversal {
	
	
	static class Node {
		int val;
		Node left, right;
		Node(int val){
			this.val = val;
			this.left = null;
			this.right = null;
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
	
    public void depthOrderTraversal(Node root){
        if(root==null){
            System.out.println("empty tree");
            return;
        }       
        Stack<Node> stack=new Stack<Node>();
        stack.push(root);       
        while(stack.isEmpty()==false){
            Node Node=stack.pop();
            System.out.print(Node.val+"    ");
            if(Node.right!=null){
                stack.push(Node.right);
            }
            if(Node.left!=null){
                stack.push(Node.left);
            }           
        }
        System.out.print("\n");
    }


    public void levelOrderTraversal(Node root){
        if(root==null){
            System.out.println("empty tree");
            return;
        }
        Queue<Node> queue=new LinkedList<Node>();
        queue.offer(root);
        while(queue.isEmpty()==false){
        	Node Node=queue.poll();
            System.out.print(Node.val+"    ");
            if(Node.left!=null){
                queue.add(Node.left);
            }
            if(Node.right!=null){
                queue.add(Node.right);
            }
        }
        System.out.print("\n");
    }

	private void levelTraversal(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		q.offer(root);
		while(!q.isEmpty()){
			Node cur = q.poll();
			System.out.print(cur.val + " ");
			if (cur.left != null) {
				q.offer(cur.left);
			}
			if (cur.right != null) {
				q.offer(cur.right);
			}
		}
	}

	private void traverseByLevelFromTop(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		q.offer(root);

		int inCount = 1;  
		int outCount = 0;  

		while(!q.isEmpty()){
			Node cur = q.poll();
			System.out.print(cur.val + " ");
			outCount++;  
			if (cur.left != null) {
				q.offer(cur.left);
			}
			if (cur.right != null) {
				q.offer(cur.right);
			}

			if (outCount == inCount) {  
				System.out.println();  
				inCount = q.size();  
				outCount = 0;  
			}  
		}
	}

	private void traverseByLevelFromBottom(Node Node) {  
		if (Node == null) {  
			return;  
		}  

		List<Node> list = new ArrayList<Node>();  
		list.add(Node);  
		list.add(new Node(-1)); 

		int i = 0;  
		int size = list.size();  

		while (i < size) {

			System.out.println("i:　" + i + "  size: " + + size);

			Node curNode = list.get(i);  

			if (curNode.right != null) {  
				list.add(curNode.right);  
			}   

			if (curNode.left != null) {  
				list.add(curNode.left);  
			}  
			
			i++;  
			if (i == size) {
				System.out.println("--> i equals size " + size);

				if (curNode.val != -1 && curNode.left == null && curNode.right == null) {   //已经遍历到最底层的最后一个元素，结束循环  
					break;  
				}  
				size = list.size();  
				list.add(new Node(-1));       
			}  
		}  

		//从后往前遍历，相当于“栈”  

		System.out.println("list final size: "+ list.size());
		for(int j = list.size()-1; j>=0; j--){  
			int val = list.get(j).val;  
			if (val == -1) {  
				System.out.println();  
			} else {  
				System.out.print(val + " ");  
			}  
		}
	}
//Find Lowest Common Ancestor
	private Node findLCA(Node root, Node Node1, Node Node2) {
		if(root == null) return null;

		if(root.val == Node1.val || root.val == Node2.val){
			return root;
		}

		Node left_lca = findLCA(root.left, Node1, Node2);
		Node right_lca = findLCA(root.right, Node1, Node2);

		//Found LCA: because 2 target nodes on appeared on the left and right
		if(left_lca != null && right_lca != null){
			return root;
		}
		
		//return to upper stack if not found
		return left_lca != null ? left_lca : right_lca;
	}
	
	private Node search(Node Node, int target)
	{
		Node result = null;
		
		if (Node == null)
			return null;
		
		if (Node.val == target)
			return Node;
		
		if (Node.left != null)
			result = search(Node.left,target);
		
		if (result == null)
			result = search(Node.right,target);
		return result;

	}

	void mirror(Node Node) {
		if (Node == null) {
			return;
		} else {
			Node temp;

			/* do the subtrees */
			mirror(Node.left);
			mirror(Node.right);

			/* swap the objects/values in this Node */
			temp = Node.left;
			Node.left = Node.right;
			Node.right = temp;
		}
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

		Tree_MyBinaryTreeTraversal tt = new Tree_MyBinaryTreeTraversal();

		System.out.println("preOrder: ");  
		tt.preOrder(root);
		System.out.println("");  
		
		//
//		System.out.println();
//
		System.out.println("inOrder: ");  
		tt.inOrder(root);
		System.out.println("");  
//
//		System.out.println();
//
		System.out.println("postOrder: ");  
		tt.postOrder(root);
		System.out.println("");  
//
		System.out.println("levelTraversal: ");  
		tt.levelTraversal(root);
		System.out.println("");  
//
//
		System.out.println("traverseByLevelFromTop: ");  
		tt.traverseByLevelFromTop(root);
//
//		System.out.println();
//
//		System.out.println("traverseByLevelFromBottom: ");  
//		tt.traverseByLevelFromBottom(root);
//
//		System.out.println();
//
		System.out.println("findLCA: ");  
		Node lca = tt.findLCA(root,Node4, Node6);
		System.out.println("lca: " + lca.val);
//
//		System.out.println();
//
//		System.out.println("search Node: ");  
//		Node found = tt.search(root, 11);
//		if(found!=null) System.out.println("found: " + found.val);
//		else{ System.out.println("Not found"); }
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
		tt.depthOrderTraversal(root);
		
		System.out.println("BFS:");
		tt.levelOrderTraversal(root);
	}








}
