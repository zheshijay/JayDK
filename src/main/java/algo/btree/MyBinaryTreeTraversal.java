package algo.btree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class MyBinaryTreeTraversal {


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
            Node node=stack.pop();
            System.out.print(node.val+"    ");
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
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
        	Node node=queue.poll();
            System.out.print(node.val+"    ");
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
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

	private void traverseByLevelFromBottom(Node node) {  
		if (node == null) {  
			return;  
		}  

		List<Node> list = new ArrayList<Node>();  
		list.add(node);  
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

	private Node findLCA(Node root, Node node1, Node node2) {
		if(root == null) return null;

		if(root.val == node1.val || root.val == node2.val){
			return root;
		}

		Node left_lca = findLCA(root.left, node1, node2);
		Node right_lca = findLCA(root.right, node1, node2);

		if(left_lca != null && right_lca != null){
			return root;
		}
		return left_lca != null ? left_lca : right_lca;
	}


	private Node search(Node node, int target)
	{
		Node result = null;
		if (node == null)
			return null;
		if (node.val == target)
			return node;
		if (node.left != null)
			result = search(node.left,target);
		if (result == null)
			result = search(node.right,target);
		return result;

	}

	void mirror(Node node) {
		if (node == null) {
			return;
		} else {
			Node temp;

			/* do the subtrees */
			mirror(node.left);
			mirror(node.right);

			/* swap the objects/values in this node */
			temp = node.left;
			node.left = node.right;
			node.right = temp;
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


		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);

		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.right = node6;
		node5.left = node7;
		node5.right = node8;

		Node root = node1;

		MyBinaryTreeTraversal tt = new MyBinaryTreeTraversal();
//
//		System.out.println("preOrder: ");  
//		tt.preOrder(root);
//
//		System.out.println();
//
//		System.out.println("inOrder: ");  
//		tt.inOrder(root);
//
//		System.out.println();
//
//		System.out.println("postOrder: ");  
//		tt.postOrder(root);
//
//		System.out.println("levelTraversal: ");  
//		tt.levelTraversal(root);
//
//		System.out.println();
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
//		Node lca = tt.findLCA(root,node4, node6);
//		System.out.println("lca: " + lca.val);
//
//		System.out.println();
//
//		System.out.println("search node: ");  
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
		tt.depthOrderTraversal(root);
		
		
		System.out.println("BFS:");
		tt.levelOrderTraversal(root);
		 




	}








}
