package algo.linkedlist;


public class ReverseLinkedListTest {


	static class ListNode{
		int val;
		ListNode next;
		ListNode(int val){
			this.val = val; 
			this.next = null;
		}


	}

	public void printList(ListNode ListNode ){

		//		System.out.print("printList: " + ListNode.val);
		System.out.println();
		while(ListNode!=null){
			System.out.print(ListNode.val);
			ListNode = ListNode.next;
		}
	}



	public ListNode reverseLinkedList(ListNode head){

		/*
		 * 
		 *           1 -> 2 -> 3 ->4 ->5
		 * 
		 * newHead   cur  next
		 * 
		 */

		ListNode newHead = null;
		ListNode curNode = head;


		while(curNode!=null){
			ListNode nextNode = curNode.next;
			curNode.next = newHead;
			newHead = curNode;
			curNode = nextNode;
		}



		return newHead;
	}



	public static void main(String[] args){
		ReverseLinkedListTest test = new ReverseLinkedListTest();

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

				ListNode newListNodeList = test.reverseLinkedList(ListNode1);

		System.out.println("-- after");
				test.printList(newListNodeList);

		//		test.printList(test.reversedList(ListNode1));		


	}

}
