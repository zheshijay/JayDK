package algo.linkedlist;

/**
 * 
 * 
 * [解题思路]
经典题�?�双指针，一个指针先走n步，然后两个同步走，直到第一个走到终点，第二个指针就是需要删除的节点。唯�??要注意的就是头节点的处理，比如，
1->2->NULL, n =2; 这时，要删除的就是头节点�??
 * 
 *  For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second ListNode from the end, the linked list becomes 1->2->3->5.

 * 
 * @author ZShi
 *
 */

public class RemoveNthNodeFromEnd {

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}


	void printList(ListNode ListNode) {
		while (ListNode != null) {
			System.out.print(ListNode.val + " ");
			ListNode = ListNode.next;
		}
	}

	public ListNode removeNthNodeFromEnd(ListNode head, int n){  
		if (n <= 0) {
			return null;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode preDelete = dummy;
		
		for (int i = 0; i < n; i++) {
			if (head == null) {
				return null;
			}
			head = head.next;
		}
		
		while (head != null) {
			head = head.next;
			preDelete = preDelete.next;
		}
		
		preDelete.next = preDelete.next.next;
		return dummy.next;
	}


	public ListNode myRemoveNthNodeFromEnd(ListNode head, int n){

		if(head == null || n < 1) return head;
		
		ListNode fast = head;
		ListNode slow = head;
		
		int i=0;
		while(i < n){
			fast = fast.next;
			i++;
		}
		
		ListNode dummy = new ListNode(0);
		dummy.next = slow;
		slow=dummy;
		
		while(fast!=null){
			fast = fast.next;
			slow = slow.next;
		}
		
		slow.next = slow.next.next;
		
		return dummy.next;
		
		
	}


	public static void main(String[] args){
		ListNode ListNode1 = new ListNode(1);
		ListNode ListNode2 = new ListNode(2);
		ListNode ListNode3 = new ListNode(3);
		ListNode ListNode4 = new ListNode(4);
		ListNode ListNode5 = new ListNode(5);

//		ListNode1.next = ListNode2;
//		ListNode2.next = ListNode3;
//		ListNode3.next = ListNode4;
//		ListNode4.next = ListNode5;

		ListNode head = ListNode1;
		RemoveNthNodeFromEnd test = new RemoveNthNodeFromEnd();
		ListNode result = test.myRemoveNthNodeFromEnd(head, 1);

		while(result!=null){
			System.out.print(result.val);
			result = result.next;
			//			 System.out.print(ListNode1.data);
		}

	}







}
