package algo.linkedlist;


public class CycleDetect {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) 
		{ val = x; }
	}

	public boolean hasCycle(ListNode head) {
		if(head==null) return false;

		ListNode slow = head, fast=head;

		while(fast.next!=null && fast.next.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast) return true;
		}

		return false;
	}

	
	public static void main(String[] args){

		CycleDetect test = new CycleDetect();


		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);

		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
//		node5.next = node3;
		//		LinkedList_RemoveDupNode.remove_duplicates(head);
		boolean result = test.hasCycle(node1);
		System.out.print("result=====> "+result);
	}

}
