package algo.linkedlist;


public class CycleStartNode {
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
	
	
	public ListNode findStartNode(ListNode head){
		
		if(head==null) return null;

		
		//find the meet pointer when detect the cycle
		ListNode slow = head, fast=head;

		while(fast.next!=null && fast.next.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast) break;
		}
		
		//move slow to the start of list
		slow = head;
		
		while(fast.next!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next;
			if(slow==fast) break;
		}

		return slow;  //return either slow or fast
	}
	
	public static void main(String[] args){

		CycleStartNode test = new CycleStartNode();


		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);

		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node3;
		//		LinkedList_RemoveDupNode.remove_duplicates(head);
		ListNode result = test.findStartNode(node1);
		System.out.print("result=====> "+result.val);
	}

}
