package algo.linkedlist;

import algo.linkedlist.ReverseLinkedList.Node;

public class PartitionLinkedList {

	/*
	 * 
	 * 
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5. 

	 */
	static class Node {
		int val;
		Node next;
		Node(int x) { val = x; }

		public String toString(){
			Node temp = next;

			String vals = "";
			vals+=val+"->";
			while(temp!=null){
				vals+=temp.val+"->";
				temp = temp.next;
			}
			return vals;
		}

	}


	public Node partition(Node head, int x) {
		
		Node dummy1 = new Node(0);   // use dummy1 to return the final res
		Node dummy2 = new Node(0);   //use dummy2 to connect dummy1
		
		Node p1 = dummy1;
		Node p2 = dummy2;
		
		while(head!=null){
			
			if(head.val < x){   //put all number less than x to dummy1
				p1.next = head;
				p1 = head;    //move pointer to next index
			}else{
				p2.next = head;
				p2 = head;    //move pointer to next index
			}
			
			head = head.next;
		}
		
		//Conect 2 dummy list
		p1.next = dummy2.next;
		p2.next = null;  //avoid infinite loop
		
		return dummy1.next;
	}



	public static void main(String[] args){
		PartitionLinkedList test = new PartitionLinkedList();

		Node Node1 = new Node(1);
		Node Node2 = new Node(4);
		Node Node3 = new Node(3);
		Node Node4 = new Node(2);
		Node Node5 = new Node(5);
		Node Node6 = new Node(2);

		Node1.next = Node2;
		Node2.next = Node3;
		Node3.next = Node4;
		Node4.next = Node5;
		Node5.next = Node6;
		//		Node5.next = null;

		System.out.println("-- before");
		System.out.println(Node1);

		Node newNodeList = test.partition(Node1, 3);
		System.out.println("");
		System.out.println("-- after");
		System.out.println(newNodeList);

		//		test.printList(test.reversedList(Node1));		


	

	}
}
