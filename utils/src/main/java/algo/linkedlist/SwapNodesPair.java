package algo.linkedlist;

import linkedlist.RemoveNodeFromLinkedList.ListNode;

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
	 */
	 public ListNode mySwapNode(ListNode head){


		 ListNode dummy = new ListNode(0);
		 dummy.next = head;
		 ListNode current = dummy;

		 while(current.next!=null && current.next.next!=null){
			 ListNode node1 = current.next;
			 ListNode node2 = current.next.next;

			 node1.next = node2.next;
			 node2.next = node1;
			 current.next =  node2;

			 current = current.next.next;

		 }

		 return dummy.next;

	 }


	 void printList(ListNode node) {
		 while (node != null) {
			 System.out.print(node.val + " ");
			 node = node.next;
		 }
	 }

	 public static void main(String[] args){
		 SwapNodesPair test = new SwapNodesPair();
		 ListNode node1 = new ListNode(1);
		 ListNode node2 = new ListNode(2);
		 ListNode node3 = new ListNode(3);
		 ListNode node4 = new ListNode(4);
		 ListNode node5 = new ListNode(5);


		 node1.next = node2;
		 node2.next = node3;
		 node3.next = node4;
		 node4.next = node5;

		 ListNode head = node1;
		 ListNode result = test.mySwapNode(head);
		 test.printList(result);


	 }
}
