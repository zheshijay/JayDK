package algo.linkedlist;

import java.util.Hashtable;
import crackingInterview.LinkedList_RemoveDuplicateNode;

public class LinkedList_RemoveDupNode {

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
	 * Remove duplicate notes use buffer ( additional classes like hashTable...)
	 * 
	 * 
	 * @author ZShi
	 * @param node
	 */
	public static void remove_duplicates(Node node) {
		
		Hashtable table = new Hashtable();
		Node curNode = null;
		while(node!=null){
			System.out.println("checking node " + node.data);

			if(table.containsKey(node.data)) {
				curNode.next = node.next;
			}
			else {
				table.put(node.data, true);
				curNode = node;
			}
			System.out.println("-- curNode value is " + curNode.data);
			
			node = node.next;
		}
	}
	
	/**
	 * 
	 * Remove duplicate notes without buffer (sorted list)
	 * 
	 * 
	 * @author ZShi
	 * @param node
	 */
	public static void remove_duplicates2(Node node) {
		if (node == null) return;
		
		 /*Another reference to head*/
        Node runningNode = node;

        
	    /* Traverse list till the last node */
        while (node != null) {
            /*currentNode current node with the next node */
            if (runningNode.data == node.data) {
            	runningNode.next = node.next;
            	System.gc();
            }
            else // advance if no deletion
            	runningNode = node;
            
            node = node.next;
        }
        
	}	

	void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	public static void main(String[] args){
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(3);
		Node node5 = new Node(8);

		Node head = new Node();


		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		head = node1;

//		LinkedList_RemoveDupNode.remove_duplicates(head);
		LinkedList_RemoveDupNode.remove_duplicates2(head);
		
		while(head!=null){
			System.out.print(head.data);
			head = head.next;
			//			 System.out.print(node1.data);
		}

	}

}
