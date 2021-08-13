package algo.treeMatrixGraph;

public class Node {
			int val;
			Node left, right;
			Node(int val){
				this.val = val;
				this.left = null;
				this.right = null;
			}
			
			public String toString(){
				return val+"";
			}
}
