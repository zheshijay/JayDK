package algo.linkedlist;

import java.util.Stack;

import linkedlist.ReverseLinkedListTest.ListNode;



/**
 * 
 * Reverse a singly linked list.
 * 
 * @author ZShi
 *
 */
public class ReverseLinkedList {

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	/**
	 * 
	 * use buffer
	 * 
	 * @param head
	 * @return
	 */
	public ListNode reversedList(ListNode head){
		Stack<ListNode> stack = new Stack<ListNode>();

		ListNode p = head;
		while(p!=null){
			System.out.println("push :" + p.val);
			stack.push(p);
			p=p.next;
		}

		ListNode reversedListNodeHead = stack.peek();
		ListNode reversedListNodeList = stack.pop();

		while(!stack.isEmpty()){
			System.out.println("adding :" + stack.peek().val);
			reversedListNodeList.next = stack.pop();
			reversedListNodeList = reversedListNodeList.next;
		}
		reversedListNodeList.next = null;

		return reversedListNodeHead;
	}


	/**
	 * 
	 * 
	 * 1 2 3 4 5 6 7 8 9
	 */

	/* Function to reverse the linked list */
	ListNode reverse(ListNode head) {

		ListNode before = null;
		ListNode tmp = head;

		while (tmp != null) {
			ListNode next = tmp.next;

			tmp.next = before;

			before = tmp;

			tmp = next;

			this.printList(before);
		}
		head = before;

		return head;
	}


	ListNode myrReverse(ListNode head) {

		ListNode reversed = null;
		ListNode pointer = head;

		while(pointer!=null){
			ListNode nextNode = pointer.next;   //get nextNode first, because we want to lost the connect point of next one

			pointer.next = reversed;   //pointer (current node) link to previous reversed node
			reversed = pointer;         // move reversed to point to the new reversed linkedlist head
			pointer = nextNode;         // move to next.
		}
		head = reversed;

		return head;
	}

	public void printList(ListNode ListNode ){

		//		System.out.print("printList: " + ListNode.val);
		System.out.println();
		while(ListNode!=null){
			System.out.print(ListNode.val);
			ListNode = ListNode.next;
		}
	}

	
	ListNode myReverse2(ListNode head) {
		
		ListNode pre = null, cur = head, next = null;

		while(cur!=null){
			next = cur.next;  //save the address of next node
			
			cur.next = pre; //.point cur to pre
			pre = cur;   //move pre to cur node
			cur = next;   //move on to next round
		}
		
		return pre;
		
	}


	public static void main(String[] args){
		ReverseLinkedList test = new ReverseLinkedList();

		ListNode ListNode1 = new ListNode(1);
		ListNode ListNode2 = new ListNode(2);
		ListNode ListNode3 = new ListNode(3);
		ListNode ListNode4 = new ListNode(4);
		ListNode ListNode5 = new ListNode(5);


		ListNode1.next = ListNode2;
		ListNode2.next = ListNode3;
		ListNode3.next = ListNode4;
		ListNode4.next = ListNode5;
		//		ListNode5.next = null;

		System.out.println("-- before");
		test.printList(ListNode1);

		ListNode newListNodeList = test.myReverse2(ListNode1);

		System.out.println("-- after");
		test.printList(newListNodeList);

		//		test.printList(test.reversedList(ListNode1));		


	}

}
