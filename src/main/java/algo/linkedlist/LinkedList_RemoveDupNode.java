package algo.linkedlist;

import java.util.HashSet;
import java.util.Hashtable;
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

	void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}


	//my practice
	public Node removeDup(Node head){
		Node dummy = new Node(0);
		dummy.next = head;
		head = dummy;
		while(head.next!=null){
			int curVal = head.next.data;
			while( head.next.next!=null && curVal == head.next.next.data ){
				head.next.next = head.next.next.next;
			}
			head = head.next;
		}
		return dummy.next;
	}

	public Node removeDup2(Node head){
		Node dummy = new Node(0);
		dummy.next = head;
		head = dummy;
		while(head.next!=null){
			int curVal = head.next.data;
			while( head.next.next!=null && curVal == head.next.next.data ){
				head.next = head.next.next.next;
			}
			head = head.next;
		}
		return dummy.next;
	}


	//use hashtable
	public Node removeDup3(Node head){

		HashSet<Integer> set = new HashSet<>();

		Node dummy = new Node(0);
		dummy.next = head;
		head = dummy;
		while(head.next!=null){
			if(set.contains(head.next.data)){
				head.next = head.next.next;
			}else{
				set.add(head.next.data);
				head=head.next;
			}


		}
		return dummy.next;
	}
	

	public static void main(String[] args){
		LinkedList_RemoveDupNode test = new LinkedList_RemoveDupNode();

		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(3);
		Node node5 = new Node(5);

		Node head = new Node();

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		head = node1;
		
		Node target = new Node(3);

		//		LinkedList_RemoveDupNode.remove_duplicates(head);
//		test.removeNode(head, target);

		while(head!=null){
			System.out.print(head.data);
			head = head.next;
			//			 System.out.print(node1.data);
		}

	}

}
