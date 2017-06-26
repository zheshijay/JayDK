package algo.linkedlist;

public class SwapNodesPair {

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}


	public ListNode swapNode(ListNode head){
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode current = dummy;

		while (current.next != null && current.next.next != null) {
			ListNode first = current.next;
			ListNode second = current.next.next;

			first.next = second.next;
			current.next = second;
			current.next.next = first;


			current = current.next.next;
		}
		return dummy.next;
	}


	/**
	 * 
	 * 1 2 3 4 5 6
	 * 
	 * [cur] - > [n1] ->[n2] - [n3]
	 * 
	 * 
	 * 
	 * 1 2 3 4 5  =>  2 1 4 3 5 


1->2->3->4->5->6->7

2->1 4->3 6->5


	 */
	 public ListNode mySwapNode(ListNode head){


		 ListNode dummy = new ListNode(0);
		 dummy.next = head;
		 head = dummy;

		 while(head.next!=null && head.next.next!=null){
			 ListNode node1 = head.next;
			 ListNode node2 = head.next.next;

			 node1.next = node2.next;
			 node2.next = node1;
			 head.next =  node2;

			 head = head.next.next;

		 }

		 return dummy.next;

	 }


	 void printList(ListNode node) {
		 while (node != null) {
			 System.out.print(node.val + " ");
			 node = node.next;
		 }
	 }
	 
	 
	 public  void memTest(){
		 
		 Node node1 = new Node(1);
		 Node node2 = new Node(2);
		 Node node3 = new Node(3);
		 
		 Node head = node1;
		 
		 node1.next = node2;
		 
		 System.out.println("head is: "+head.val);
		 
		 
		 
		 
		 
	 }

	 public static void main(String[] args){
		 SwapNodesPair test = new SwapNodesPair();
//		 ListNode node1 = new ListNode(1);
//		 ListNode node2 = new ListNode(2);
//		 ListNode node3 = new ListNode(3);
//		 ListNode node4 = new ListNode(4);
//		 ListNode node5 = new ListNode(5);
//
//
//		 node1.next = node2;
//		 node2.next = node3;
//		 node3.next = node4;
//		 node4.next = node5;
//
//		 ListNode head = node1;
//		 ListNode result = test.mySwapNode(head);
//		 test.printList(result);
test.memTest();

	 }
}
