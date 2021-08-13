package algo.jianzhioffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q006PrintNodes2 {
	
	public void printInOrder(ListNode node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}
	
//	public void printInReverseOrder(Node node) {
//		Node pre, current, next;
//		
//		pre = null;
//		current = node;
//		
//		while (current != null) {
//			next = current.next;
//			current.next = pre;
//			pre = current;
//			current = next;
//		}
//		
//		node = pre;
//		
//		
//		while (node != null) {
//			System.out.print(node.val + " ");
//			node = node.next;
//		}
//	}
	
	
	 public int[] reversePrint(ListNode head) {
		 
		 
		 int size = 0;
		 ListNode pre, cur, next;
		 
		 pre = null;
		 cur = head;
		 while(cur != null) {
			 size++;
			 next = cur.next;
			 cur.next = pre;
			 pre = cur;
			 cur = next;
		 }
		 
		 
		 ListNode newHead = pre;
		 
		 int[] res = new int[size];
		 
		 
		 System.out.println("newHead is:" + newHead);
		 int i = 0;
		 while(newHead != null) {
			 System.out.println("pre value:" + pre.val);
			 res[i++] = newHead.val;
			 newHead = newHead.next;
		 }
		
	
		 return res;
	    }
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		
		Q006PrintNodes2 test = new Q006PrintNodes2();
		
		System.out.println("Before:");
		test.printInOrder(n1);
		
	
		int[] res = test.reversePrint(n1);
		System.out.println();
		System.out.println("After:" + Arrays.toString(res));
		
		
		
		
	}
}