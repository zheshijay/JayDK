package algo.linkedlist;

import corejava.datastructure.linkedlist.leetcode.RemoveNodeFromLinkedList.ListNode;

public class SortList {
	
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	//merge two sorted list, return result head
	public ListNode merge(ListNode h1, ListNode h2){
		if(h1 == null){
			return h2;
		}
		if(h2 == null){
			return h1;
		}

		if(h1.val < h2.val){
			h1.next = merge(h1.next, h2);
			return h1;
		}
		else{
			h2.next = merge(h1, h2.next);
			return h2;
		}

	}

	public ListNode sortList(ListNode head) {
		//bottom case
		if(head == null){
			return head;
		}
		if(head.next == null){
			return head;
		}
		
		//p1 move 1 step every time, p2 move 2 step every time, pre record node before p1
		ListNode p1 = head;
		ListNode p2 = head;
		ListNode pre = head;
		
		while(p2 != null && p2.next != null){
			pre = p1;
			p1 = p1.next;
			p2 = p2.next.next;
		}
		//change pre next to null, make two sub list(head to pre, p1 to p2)
		pre.next = null;
		
		//handle those two sub list
		ListNode h1 = sortList(head);
		ListNode h2 = sortList(p1);

		return merge(h1, h2);
	}
	

	public void printList(ListNode ListNode ){

		//		System.out.print("printList: " + ListNode.val);
		System.out.println();
		while(ListNode!=null){
			System.out.print(ListNode.val);
			ListNode = ListNode.next;
		}
	}
	
	public static void main(String[] args){

		SortList test = new SortList();


		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(5);
		ListNode node3 = new ListNode(4);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(2);

		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
//		node5.next = node3;
		//		LinkedList_RemoveDupNode.remove_duplicates(head);
		ListNode result = test.sortList(node1);
		test.printList(result);
		

	}
}
