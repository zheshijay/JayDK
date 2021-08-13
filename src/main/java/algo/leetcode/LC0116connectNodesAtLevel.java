package algo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import algo.jianzhioffer.TreeNode;

public class LC0116connectNodesAtLevel {

	
	public Node connect(Node root) {
		if(root==null) {
			return root;
		}
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(queue.size()>0) {
			int size = queue.size();
			//将队列中的元素串联起来
			Node tmp = queue.get(0);
			for(int i=1;i<size;++i) {
				tmp.next = queue.get(i);
				tmp = queue.get(i);
			}
			//遍历队列中的每个元素，将每个元素的左右节点也放入队列中
			for(int i=0;i<size;++i) {
				tmp = queue.remove();
				if(tmp.left!=null) {
					queue.add(tmp.left);
				}
				if(tmp.right!=null) {
					queue.add(tmp.right);
				}
			}
		}
		return root;
	}

	// Driver code
	public static void main(String args[]) {
		LC0116connectNodesAtLevel test = new LC0116connectNodesAtLevel();
		
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		
		
		
		Node node = test.connect(n1);
		System.out.println(node.left.next.val);
		
	
//		while (true) {
//			System.out.println(node.val);
////			System.out.println(node.next.val);
//			node = node.next;
//		}
		
		
	}
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
