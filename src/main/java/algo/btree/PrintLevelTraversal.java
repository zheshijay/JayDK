package algo.btree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintLevelTraversal {
	
	private static void printNodeForEachLevel(Node root) {
		
		Queue<Node> queue = new LinkedList();
		
		queue.offer(root);
		
		int inCount = 1;
		int outCount = 0;
		
		while(!queue.isEmpty()){
			Node node = queue.poll();
			outCount++;
			
			System.out.print(node.val + " ");
			
			if(node.left != null){
				queue.offer(node.left);
			}
			
			if(node.right != null){
				queue.offer(node.right);
			}
			
			if(inCount == outCount){
				System.out.println();
				inCount = queue.size();
				outCount = 0;
			}
			
		}

		
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
		Node node8 = new Node(8);
		Node node9 = new Node(9);
		
		node1.left = node3;
		node1.right = node5;
		node3.left = node2;
		node3.right = node4;
		node5.right = node7;
		node2.left = node9;
		node4.right = node8;
		
		printNodeForEachLevel(node1);
		

	}

	

}
