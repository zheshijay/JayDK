package algo.jianzhioffer;

public class Q006PrintNodes {
	
	public void printInOrder(Node node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}
	
	public void printInReverseOrder(Node node) {
		Node pre, current, next;
		
		pre = null;
		current = node;
		
		while (current != null) {
			next = current.next;
			current.next = pre;
			pre = current;
			current = next;
		}
		
		node = pre;
		
		
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}
	
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		
		Q006PrintNodes test = new Q006PrintNodes();
		test.printInReverseOrder(n1);
		
		
		
	}
}