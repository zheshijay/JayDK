package algo.treeMatrixGraph;

public class SameTree {

	public boolean isSameTree(Node p, Node q) {

		if (p == null && q == null ) {
			return true;
		}

		if (p != null && q == null) {
			return false;
		}

		if (p == null && q != null) {
			return false;
		}


		return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

	/**
	 * @param args
	 */
	 public static void main(String[] args) {
		// TODO Auto-generated method stub

	 }

}
