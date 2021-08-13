package algo.leetcode;

public class DetectLoop {

	static class Node
	{
		Node next;
		int value;

		public Node(int value)
		{
			this.value = value;
		}
	}

	boolean hasLoop(Node first) {

		if(first == null) // list does not exist..so no loop either.
			return false;

		Node slow, fast; // create two references.

		slow = fast = first; // make both refer to the start of the list.

		while(true) {

			slow = slow.next;          // 1 hop.

			if(fast.next != null)
				fast = fast.next.next; // 2 hops.
			else
				return false;          // next node null => no loop.

			if(slow == null || fast == null) // if either hits null..no loop.
				return false;

			if(slow == fast) // if the two ever meet...we must have a loop.
				return true;
		}
	}

	public static void main(String[] args){
		
		DetectLoop detect = new DetectLoop();
		
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node3;
		
		System.out.println("has loop: " + detect.hasLoop(node1));
	}

}
