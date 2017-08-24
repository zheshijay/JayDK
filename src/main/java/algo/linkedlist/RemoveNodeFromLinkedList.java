package algo.linkedlist;


/**
 * 
 * 
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5 
 * 
 * @author ZShi
 *
 */
public class RemoveNodeFromLinkedList {

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	/**
	 * Use previous pointer ( not the best solution)
	 * 
	 * 
	 * @param head
	 * @param target
	 * @return
	 */
	public ListNode removeNode(ListNode head, int target){
		ListNode p = head;
		ListNode previousNode = head;
		
		while(p!=null){
			if(p.val == target){
				if(p.next!=null){
					p.val = p.next.val;
					p.next = p.next.next;
				}else{
					previousNode.next = null;
					p=p.next;
				}
			}else{
				previousNode = p;
				p=p.next;
			}
		}
		return head;
	}
	
	 public ListNode removeElements(ListNode head, int val) {
	        ListNode dummy = new ListNode(0);
	        dummy.next = head;
	        head = dummy;
	        
	        while (head.next != null) {
	            if (head.next.val == val) {
	                head.next = head.next.next;
	            } else {
	                head = head.next;
	            }
	        }
	        
	        return dummy.next;
	    }
	 
	 public ListNode removeElementsPractice(ListNode head, int val) {
		 ListNode helper = new ListNode(0);
		 helper.next = head;
		 head=helper;
		 
		 while(head.next!=null){
			 if(head.next.val == val){
				 head.next = head.next.next;
			 }else{
				 head = head.next;
			 }
		 }
		 
		 return helper.next;
	 }
	
	
	public void printList(ListNode ListNode ){

		//		System.out.print("printList: " + ListNode.val);
		System.out.println();
		while(ListNode!=null){
			System.out.print(ListNode.val);
			ListNode = ListNode.next;
		}
	}
	
	
	//practice
	public static ListNode removeNode2(ListNode head, int k){
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		
		while(head.next!=null){
			if(head.next.val == k) { //found k, remove it
				head.next = head.next.next;
			}else{
				head = head.next;
			}
		}
		
		return dummy.next;
		
		
	}

	public static void main(String[] args){
		RemoveNodeFromLinkedList test = new RemoveNodeFromLinkedList();

		ListNode ListNode1 = new ListNode(1);
		ListNode ListNode2 = new ListNode(2);
		ListNode ListNode3 = new ListNode(3);
		ListNode ListNode4 = new ListNode(4);
		ListNode ListNode5 = new ListNode(5);
		
		ListNode ListNodeA = new ListNode(3);
		ListNode ListNodeB = new ListNode(8);
		ListNode ListNodeC = new ListNode(9);


		ListNode1.next = ListNode2;
		ListNode2.next = ListNode3;
		ListNode3.next = ListNode4;
		ListNode4.next = ListNode5;
		ListNode5.next = ListNodeA;
		ListNodeA.next = ListNodeB;
		ListNodeB.next = ListNodeC;
		//		ListNode5.next = null;
		
		System.out.println("-- before");
		test.printList(ListNode1);
		
		ListNode newListNodeList = test.removeNode2(ListNode1, 9);
		System.out.println("");
		System.out.println("-- after");
		test.printList(newListNodeList);

		//		test.printList(test.reversedList(ListNode1));		


	}



}
