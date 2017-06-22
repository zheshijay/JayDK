package algo.linkedlist;

import corejava.datastructure.linkedlist.leetcode.OddEvenList.ListNode;

public class LinkedListUtil {
	
	static class Node {
		int val;
		Node next;
		Node(int x) { val = x; }
	}
	public static void printList(Node node ){
		while(node!=null){
			System.out.print(node.val);
			node = node.next;
		}
	}
}
