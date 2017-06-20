package qa;

public class FindLCA {

	public static Node findLCA(Node root, int node1,int node2){
		if(root == null) return null;

		if(root.val == node1 || root.val == node2){
			return root;
		}
		
		Node left_lca = findLCA(root.left, node1, node2);
		Node right_lca = findLCA(root.right, node1, node2);

		if(left_lca != null && right_lca != null){
			return root;
		}
		return left_lca != null ? left_lca : right_lca;
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindLCA findLCA = new FindLCA();
		
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;

		Node result = findLCA.findLCA(node1, 3, 5);
		System.out.println(result.val);
		
	}


}