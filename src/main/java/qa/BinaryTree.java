package qa;

public class BinaryTree {
	
	
	public static void getMirror(Node root){
		if(root == null) return;
		
		getMirror(root.left);
		getMirror(root.right);
		
		Node temp;
		temp = root.left;
		root.left = root.right;
		root.right = temp;
	}
	
	
	//preOrderTraversal
	public static void preOrder(Node root){
		if(root == null) return;
		
		System.out.print(root.val);
		preOrder(root.left);
		preOrder(root.right);
	}
	
	
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		
		node1.left = node2;
		node1.right = node3;
		node2.right = node4;
		
		Node root = node1;
		
		System.out.println("original: ");
		preOrder(root);
		
		getMirror(root);
		
		System.out.println("mirror: ");
		preOrder(root);
		
		
	}

}
