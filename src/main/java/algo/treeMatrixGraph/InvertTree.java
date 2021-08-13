package algo.treeMatrixGraph;

public class InvertTree {
	
	public Node invertTree(Node root) {
	    if (root == null) {
	        return null;
	    }
	    Node right = invertTree(root.right);
	    Node left = invertTree(root.left);
	    root.left = right;
	    root.right = left;
	    return root;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
