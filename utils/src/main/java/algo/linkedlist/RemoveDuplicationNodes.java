package algo.linkedlist;

import java.util.Hashtable;

import corejava.datastructure.linkedlist.leetcode.LinkedList_RemoveDupNode.Node;

public class RemoveDuplicationNodes {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}


	public ListNode removeDupNodes(ListNode head){
		ListNode h = head;
		Hashtable table = new Hashtable();
		
		ListNode helper = new ListNode(0);
		helper.next = head;
		head = helper;
		

		while(head.next!=null){
			if(table.containsKey(head.next.val)){
				System.out.println("removeing " + head.next.val);
				head.next = head.next.next;
			}else{
				table.put(head.next.val, true);
				head = head.next;
			}
		}
		return h;
	}
	
	public static void main(String[] args){
		RemoveDuplicationNodes test = new RemoveDuplicationNodes();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(2);
		ListNode node5 = new ListNode(2);




		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		ListNode head = node1;

		ListNode uniqueNodes = test.removeDupNodes(head);
		
		while(uniqueNodes!=null){
			System.out.print(uniqueNodes.val);
			uniqueNodes = uniqueNodes.next;
			//			 System.out.print(node1.data);
		}

	}
	
}
