package algo.linkedlist;

import java.util.Hashtable;

import algo.linkedlist.LinkedList_RemoveDupNode.Node;

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
	

	public void removeNode(Node head, Node target){

		Node dummy = new Node(0);
		dummy.next = head;
		head = dummy;

		while(head.next!=null){
			if(head.next.data == target.data){
				System.out.println("remove " + target.data);
				head.next = head.next.next;			//remove node
			}else
			head = head.next;
		}

	}
	
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
