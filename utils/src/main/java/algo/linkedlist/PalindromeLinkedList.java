package algo.linkedlist;

import java.util.Stack;

import corejava.datastructure.linkedlist.leetcode.OddEvenList.ListNode;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * @author ZShi
 *
 */
public class PalindromeLinkedList {
	static class Node {
		int val;
		Node next;
		Node(int x) { val = x; }
	}
	
	public boolean isPalindrome(Node head){
		Stack<Node> stack = new Stack<Node>();
		
		Node nodePointer = head;
		Node headNode = head;
		
		//push to stack
		while(nodePointer!=null){
			stack.push(nodePointer);
			nodePointer = nodePointer.next;
		}
		
		//compare
		while(!stack.isEmpty()){
			Node eachNode = stack.pop();
			Node oriNode = headNode;
			if(eachNode.val != oriNode.val) return false;
			headNode=headNode.next;
			
		}
		return true;
	}
	
	public static void main(String[] args){
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(2);
		Node node5 = new Node(1);


		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		PalindromeLinkedList test = new PalindromeLinkedList();
		
		System.out.println(test.isPalindrome(node1));
		
		
		
	}
	
	
}
