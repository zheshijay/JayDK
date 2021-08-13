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
	
	 Node reverse(Node head, int k) 
	    { 
	       Node current = head; 
	       Node next = null; 
	       Node prev = null; 
	         
	       int count = 0; 
	  
	       /* Reverse first k nodes of linked list */
	       while (count < k && current != null)  
	       { 
	           next = current.next; 
	           current.next = prev; 
	           prev = current; 
	           current = next; 
	           count++; 
	       } 
	  
	       /* next is now a pointer to (k+1)th node  
	          Recursively call for the list starting from current. 
	          And make rest of the list as next of first node */
	       if (next != null)  
	          head.next = reverse(next, k); 
	  
	       // prev is now head of input list 
	       return prev; 
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
