package algo.btree;

public class MergeTwoBinaryTrees {
	  public Node merge(Node t1, Node t2) {
	        if(t1 == null && t2 == null) {
	            return null;
	        }
	        
	        Node newNode = new Node(-1);
	        if(t1 == null) {
	            newNode.val = t2.val;
	            newNode.left = merge(null, t2.left);
	            newNode.right = merge(null, t2.right);
	        }
	        else if(t2 == null) {
	            newNode.val = t1.val;
	            newNode.left = merge(t1.left, null);
	            newNode.right = merge(t1.right, null);
	        }
	        else {
	            newNode.val = t1.val + t2.val;
	            newNode.left = merge(t1.left, t2.left);
	            newNode.right = merge(t1.right, t2.right);
	        }
	        
	        return newNode;
	    }
}
