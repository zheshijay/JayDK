package algo.linkedlist;

import java.util.Hashtable;
import crackingInterview.LinkedList_RemoveDuplicateNode;

public class LinkedList_RemoveGivenNode {

	static class Node {

		int data;
		Node next;
		Node() {
			next = null;
		}

		Node(int d) {
			data = d;
			next = null;
		}
	}

	/**
	 * 
	 * @author ZShi
	 * @param node
	 */
	static void deleteNode(Node target) {
		target.data = target.next.data;
		target.next = target.next.next;
	}
	
	
	/**
	 * 
	 * @author ZShi
	 * @param node
	 */
	static void deleteNode(Node node, int target) {
		
		Node previous = node;
		while(node!=null){
			if(node.data == target){
				System.out.println("found target");
				 if(node.next!=null){
						node.data = node.next.data;
						node.next = node.next.next; 
				 }else{
					 previous.next = null;
					 node = node.next;
				 }
				
			}else{
				System.out.println("move previous");
				previous = node;
				node = node.next;
			}
				
		}
	}

	
	/**
	 * 
	 * @author ZShi
	 * @param node
	 */
	static void insertNode(Node node, int target) {

		while(node!=null){
			System.out.println("checking node " + node.data);
			
			if(node.data == target){
				System.out.println("found target, insert 9");
				
				Node node9 = new Node(9);
				
				node.next = node9;
				
				node9.next = node.next;
				
				
				
				node = node.next;
//				node = node.next;
				
			}else{
				node = node.next;
			}
				
		}
	}
	
	
	/**
	 * 
	 * @author ZShi
	 * @param node
	 */
	//	void deleteNode2(Node node, int target) {
	//
	//		// When node to be deleted is head node
	//		if (node.data == target) {
	//			if (node.next == null) {
	//				System.out.println("There is only one node. The list "
	//						+ "can't be made empty ");
	//				return;
	//			}
	//
	//			/* Copy the data of next node to head */
	//			node.data = node.next.data;
	//
	//			// store address of next node
	//			target = node.next;
	//
	//			// Remove the link of next node
	//			node.next = node.next.next;
	//
	//			// free memory
	//			System.gc();
	//		}
	//	}


	public static void main(String[] args){
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);

		Node head = new Node();


		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		head = node1;

		//		LinkedList_RemoveDupNode.remove_duplicates(head);
		LinkedList_RemoveGivenNode.insertNode(head, 2);

		while(head!=null){
			System.out.print(head.data);
			head = head.next;
			//			 System.out.print(node1.data);
		}

	}

}
