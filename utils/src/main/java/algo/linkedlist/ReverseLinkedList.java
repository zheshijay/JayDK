package algo.linkedlist;

import java.util.Stack;

/**
 * 
 * Reverse a singly linked list.
 * 
 * @author ZShi
 *
 */
public class ReverseLinkedList {

	static class Node {
		int val;
		Node next;
		Node(int x) { val = x; }
	}

	/**
	 * 
	 * use buffer
	 * 
	 * @param head
	 * @return
	 */
	public Node reversedList(Node head){
		Stack<Node> stack = new Stack<Node>();

		Node p = head;
		while(p!=null){
			System.out.println("push :" + p.val);
			stack.push(p);
			p=p.next;
		}

		Node reversedNodeHead = stack.peek();
		Node reversedNodeList = stack.pop();

		while(!stack.isEmpty()){
			System.out.println("adding :" + stack.peek().val);
			reversedNodeList.next = stack.pop();
			reversedNodeList = reversedNodeList.next;
		}
		reversedNodeList.next = null;

		return reversedNodeHead;
	}


	/**
	 * 
	 * 
	 * 1 2 3 4 5 6 7 8 9
	 */

	/* Function to reverse the linked list */
	Node reverse(Node head) {

		Node before = null;
		Node tmp = head;

		while (tmp != null) {
			Node next = tmp.next;

			tmp.next = before;

			before = tmp;

			tmp = next;

			this.printList(before);
		}
		head = before;

		return head;
	}


	Node myrReverse(Node head) {

		Node reversed = null;
		Node pointer = head;

		while(pointer!=null){
			Node nextNode = pointer.next;   //get nextNode first, because we want to lost the connect point of next one

			pointer.next = reversed;   //pointer (current node) link to previous reversed node
			reversed = pointer;         // move reversed to point to the new reversed linkedlist head
			pointer = nextNode;         // move to next.
		}
		head = reversed;

		return head;
	}

	public void printList(Node Node ){

		//		System.out.print("printList: " + Node.val);
		System.out.println();
		while(Node!=null){
			System.out.print(Node.val);
			Node = Node.next;
		}
	}

	
	Node myReverse2(Node head) {
		Node pre = null, cur = head, next = null;
		while(cur!=null){
			next = cur.next;  //save the address of next node
			cur.next = pre; //.point cur to pre
			pre = cur;   //move pre to cur node
			cur = next;   //move on to next round
		}
		return pre;
	}

	
	
	
	public Node myReverseLinkedList(Node head) {
		Node pre=null, cur=head, nextNode=null;
	    while(cur!=null){
	    	nextNode = cur.next;
	    	cur.next = pre;
	    	pre = cur;
	    	cur = nextNode;
	    }
	    return pre;
	}
	
	
	public static void main(String[] args){
		ReverseLinkedList test = new ReverseLinkedList();

		Node Node1 = new Node(1);
		Node Node2 = new Node(2);
		Node Node3 = new Node(3);
		Node Node4 = new Node(4);
		Node Node5 = new Node(5);


		Node1.next = Node2;
		Node2.next = Node3;
		Node3.next = Node4;
		Node4.next = Node5;
		//		Node5.next = null;

		System.out.println("-- before");
		test.printList(Node1);

		Node newNodeList = test.myReverse2(Node1);
		System.out.println("");
		System.out.println("-- after");
		test.printList(newNodeList);

		//		test.printList(test.reversedList(Node1));		


	}

}
