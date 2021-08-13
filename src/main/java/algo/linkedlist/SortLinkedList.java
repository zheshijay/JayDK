package algo.linkedlist;

public class SortLinkedList {
	
	  public ListNode sortList(ListNode head) {
	        if (head == null || head.next == null)
	            return head;
	        
	        ListNode fast = head.next, slow = head;
	        while (fast != null && fast.next != null) {
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        ListNode tmp = slow.next;
	        slow.next = null;
	        ListNode left = sortList(head);
	        ListNode right = sortList(tmp);
	        ListNode h = new ListNode(0);
	        ListNode res = h;
	        while (left != null && right != null) {
	            if (left.val < right.val) {
	                h.next = left;
	                left = left.next;
	            } else {
	                h.next = right;
	                right = right.next;
	            }
	            h = h.next;
	        }
	        h.next = left != null ? left : right;
	        return res.next;
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

		SortLinkedList test = new SortLinkedList();


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
