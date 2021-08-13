package algo.leetcode;


import algo.treeMatrixGraph.Node2;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {

	static Node2 first;

	public static Node2 reverseList(Node2 head) {

		reverseList(head);

		return first;


	}

	public void reverseListRecursive(Node2 curr) {
		System.out.println("current node is: " + curr.val);

		if(curr==null) return;  
		if(curr.next==null){
			first = curr;
			return;
		}

		reverseListRecursive(curr.next);
		curr.next.next = curr;
		curr.next = null;

	}  
	

	public static void main(String[] args) {
		ReverseLinkedList test = new ReverseLinkedList();
		test.reverseListRecursive();
		

		Node2 node1 = new Node2(1);
		Node2 node2 = new Node2(2);
		Node2 node3 = new Node2(3);
		Node2 node4 = new Node2(4);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		first = node1;
		reverseList(first);
		
//		System.out.println("head val: " + head.val);

		Node2 cur = first.next;
		while(cur.hasNext()){
			cur = cur.next;
			System.out.println(cur.val);
		}
	
		
	}
}