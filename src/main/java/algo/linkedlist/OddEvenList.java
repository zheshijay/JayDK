package algo.linkedlist;

/*
 * 
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

The program should run in O(1) space complexity and O(nodes) time complexity.

Example:

Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.



Solution:

maintatin 2 list:  1->3->5->7->9...    and 2->4->6->8...    connect 2 list when reaches the end
 * 
 * 
 */
public class OddEvenList {
	
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public void printList(ListNode node ){
		while(node!=null){
			System.out.print(node.val);
			node = node.next;
		}
	}
	
	public ListNode oddEvenList(ListNode head) {
	    if(head == null) 
	        return head;
	 
	    ListNode result = head;
	    
	    ListNode p1 = head;
	    ListNode p2 = head.next;
	    ListNode headOfEvenNode = head.next;
	 
	    while(p1.next != null && p2.next != null){
//	            ListNode t = p2.next;
//	            if(t == null)
//	                break;
	 
	            p1.next = p2.next;
	            p1 = p1.next;
	 
	            p2.next = p1.next;
	            p2 = p2.next;
	    }
	 
	    System.out.println("p1:" + p1.val + " | p2:" + p2.val + " | headOfEvenNode:" + headOfEvenNode.val);
	    p1.next = headOfEvenNode;
	 
	    return result;
	}
	
	
	
	
	
	
	
	
	
	
	

	
	
	public static void main (String args[]) {
		OddEvenList oddEvenList = new OddEvenList();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);


		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;

//		oddEvenList.printList(node1);
		
		ListNode res = oddEvenList.oddEvenList(node1);
		oddEvenList.printList(res);
		
	}
}
