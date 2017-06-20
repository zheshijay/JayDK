package algo.btree;

public class MaxDepthBinaryTree {
	
	static Node root;

	
	public int maxDepth(Node root){
		if(root == null) return 0;
		
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		
		if(left > right){
			return left + 1;
		}else{
			return right + 1;
		}
	}
	
	
	
	public static void main(String[] args) {
		MaxDepthBinaryTree tree = new MaxDepthBinaryTree();
		  
	        tree.root = new Node(1);
	        tree.root.left = new Node(2);
	        tree.root.right = new Node(3);
	        tree.root.left.left = new Node(4);
	        tree.root.left.right = new Node(5);
	 
	        System.out.println("Height of tree is : " + tree.maxDepth(root));

	}

}
