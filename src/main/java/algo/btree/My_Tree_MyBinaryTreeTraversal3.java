package algo.btree;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class My_Tree_MyBinaryTreeTraversal3 {


	//Pre-order traverse ( Recursion )
	public void preOrder(Node head){
		if(head==null) return;
		System.out.print(head.val);
		preOrder(head.left);
		preOrder(head.right);
	}

	//Pre-order traverse ( DFS )
	public void preOrder_dfs(Node head){
		if(head==null) return;

		Stack<Node> stack = new Stack<>();
		stack.push(head);

		while(!stack.isEmpty()){
			Node curNode = stack.pop();
			System.out.print(curNode.val);

			if(curNode.right !=null){
				stack.push(curNode.right);
			}	

			if(curNode.left !=null){
				stack.push(curNode.left);
			}	
		}
	}

	//level-order traverse ( BFS )
	public void levelOrder_bfs(Node head){
		if(head==null) return;

		Queue<Node> q = new LinkedList<>();
		q.add(head);

		while(!q.isEmpty()){
			Node curNode = q.poll();
			System.out.print(curNode.val);

			if(curNode.left !=null){
				q.add(curNode.left);
			}	

			if(curNode.right !=null){
				q.add(curNode.right);
			}	
		}
	}

	//level-order traverse ( BFS ) with line break
	public void levelOrder_bfs_with_line_break(Node head){
		if(head==null) return;

		Queue<Node> q = new LinkedList<>();
		q.add(head);
		int inCount = 1;
		int outCount = 0;

		while(!q.isEmpty()){
			Node curNode = q.poll();
			outCount++;
			System.out.print(curNode.val);

			if(curNode.left !=null){
				q.add(curNode.left);
			}	

			if(curNode.right !=null){
				q.add(curNode.right);
			}	

			if(inCount == outCount){
				System.out.println();
				outCount =0;  //reset outCount
				inCount=q.size();  //next level total nodes
			}
		}
	}

	//resursion
	private Node findLCA1(Node root,  Node node1, Node node2) {
		if( root==null ) return null;

		if(root.left == node1 || root.right == node2) return root;

		Node leftLCA = findLCA1(root.left,  node1, node2);
		Node rightLCA = findLCA1(root.right,  node1, node2);

		System.out.println("leftLCA: " + leftLCA);
		System.out.println("rightLCA: " + rightLCA);


		if(leftLCA ==null && rightLCA==null) return null;
		if(leftLCA !=null && rightLCA!=null) return root;

		return leftLCA!=null?leftLCA:rightLCA;
	}


	 Node getMirror(Node node)
	    {
	        if (node == null)
	            return node;
	 
	        /* do the subtrees */
	        Node left = getMirror(node.left);
	        Node right = getMirror(node.right);
	 
	        /* swap the left and right pointers */
	        
	        System.out.println(" swap: " + node.left + " - " + node.right );
	        
	        node.left = right;
	        node.right = left;
	        return node;
	    }


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		My_Tree_MyBinaryTreeTraversal3 test = new My_Tree_MyBinaryTreeTraversal3();

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

//		System.out.println("---------- preOrder ----------");  
//		test.preOrder(root);
//
//
//		System.out.println();  
//		System.out.println("---------- Pre-Order DFS ----------");  
//		test.preOrder_dfs(root);
//
//		System.out.println();  
//		System.out.println("---------- Level Order BFS ----------");  
//		test.levelOrder_bfs(root);
//
//		System.out.println();  
//		System.out.println("---------- Level Order BFS with lin break ----------");  
//		test.levelOrder_bfs_with_line_break(root);
//
//		System.out.println();  
//		System.out.println("---------- Find LCA ----------");  
//		Node lca = test.findLCA1(root, node3, node6);
//		System.out.println("LCA is: " + lca);  
		
		System.out.println();  
		System.out.println("---------- Get mirror ----------");  
		Node mirrorTree = test.getMirror(root);
		test.levelOrder_bfs_with_line_break(mirrorTree);  


		//
		//		System.out.println();
		//
		//		System.out.println("inOrder: ");  
		//		tt.inOrder(root);
		//		//
		//		//		System.out.println();
		//		//
		//		System.out.println("postOrder: ");  
		//		tt.postOrder(root);
		//		//
		//		System.out.println("levelTraversal: ");  
		//		tt.levelTraversal(root);
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
