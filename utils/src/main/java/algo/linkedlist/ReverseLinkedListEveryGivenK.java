package algo.linkedlist;

import java.util.Stack;

import algo.utils.PrintUtils;

/**
 * 
 * Reverse a singly linked list.
 * 
 * @author ZShi
 *
 */
public class ReverseLinkedListEveryGivenK {
	/*
	 * 
Example:
Inputs:  1->2->3->4->5->6->7->8->NULL and k = 3 
Output:  3->2->1->6->5->4->8->7->NULL. 

Inputs:   1->2->3->4->5->6->7->8->NULL and k = 5
Output:  5->4->3->2->1->8->7->6->NULL. 
	 * 
	 */
	
	
	/*
	 * 1. Save the next start
	 * 2. reverse current group
	 * 3. connect to next start
	 * 
	 * 
	 */
	
	
	public Node reverseLinkedListEveryK(Node head, int k) {
		
		Node pre=null, cur=head, nextNode=null, nextStart = null;
		
		int count=0;
	    while(cur!=null){
	    	
	    	nextNode = cur.next;
	    	cur.next = pre;
	    	pre = cur;
	    	cur = nextNode;

	    	
	    }
	    return pre;
	}
	
	
	 
	
	public static void main(String[] args){
		ReverseLinkedListEveryGivenK test = new ReverseLinkedListEveryGivenK();

		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);


		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		//		Node5.next = null;
		
		Node head = node1;

		System.out.println(" original: ");
		PrintUtils.printLinkedListNode(head);
		
		System.out.println(" reversed: ");
		PrintUtils.printLinkedListNode(test.reverseLinkedListEveryK(head, 2));


	}

}
