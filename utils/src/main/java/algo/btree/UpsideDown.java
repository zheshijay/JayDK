package algo.btree;

public class UpsideDown {

	static Node getUpDownTree(Node root){
		 System.out.println("getUpDownTree: " + root.val);

		
		 if (root == null)
		        return null;
		    
		    // Working base condition
		    if( root.left == null && root.right == null) 
		    {
		        return root.left;
		    }
		    
		    Node newRoot = getUpDownTree(root.left);
		    
		    root.left.left = root.right;
		    root.left.right = root;
		    root.left = null;
		    root.right = null;

		    return newRoot;
		
	}
	
	
	static void inOrderTraversal(Node node){
		if(node == null) return;
		
		System.out.print(node.val + " ");
		inOrderTraversal(node.left);
		inOrderTraversal(node.right);
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	 Node node1 = new Node(1);
	 Node node2 = new Node(2);
	 Node node3 = new Node(3);
	 Node node4 = new Node(4);
	 Node node5 = new Node(5);
	 Node node6 = new Node(6);
	 Node node7 = new Node(7);
	 
	 node1.left = node2;
	 node1.right = node3;
	 node2.left = node4;
	 node2.right = node5;
	 node4.left = node6;
	 node4.right = node7;

	 Node root = UpsideDown.getUpDownTree(node1);
	 
//	 System.out.println("root value: " + root.val);
	 
//	 UpsideDown.inOrderTraversal(root);
	 
	}

}
