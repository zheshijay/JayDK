package algo.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class GetIntersectionNode {
	/*
	 * 统计两个链表的长度
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	    //统计链表A和链表B的长度
	    int lenA = length(headA), lenB = length(headB);

	    //如果节点长度不一样，节点多的先走，直到他们的长度一样为止
	    while (lenA != lenB) {
	        if (lenA > lenB) {
	            //如果链表A长，那么链表A先走
	            headA = headA.next;
	            lenA--;
	        } else {
	            //如果链表B长，那么链表B先走
	            headB = headB.next;
	            lenB--;
	        }
	    }

	    //然后开始比较，如果他俩不相等就一直往下走
	    while (headA != headB) {
	        headA = headA.next;
	        headB = headB.next;
	    }
	    //走到最后，最终会有两种可能，一种是headA为空，
	    //也就是说他们俩不相交。还有一种可能就是headA
	    //不为空，也就是说headA就是他们的交点
	    return headA;
	}

	//统计链表的长度
	private int length(ListNode node) {
	    int length = 0;
	    while (node != null) {
	        node = node.next;
	        length++;
	    }
	    return length;
	}
	
	/*
	 * 集合set解决
	 */
	public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
	    //创建集合set
	    Set<ListNode> set = new HashSet<>();
	    //先把链表A的结点全部存放到集合set中
	    while (headA != null) {
	        set.add(headA);
	        headA = headA.next;
	    }

	    //然后访问链表B的结点，判断集合中是否包含链表B的结点，如果包含就直接返回
	    while (headB != null) {
	        if (set.contains(headB))
	            return headB;
	        headB = headB.next;
	    }
	    //如果集合set不包含链表B的任何一个结点，说明他们没有交点，直接返回null
	    return null;
	}

	public static void main(String[] args){

		GetIntersectionNode test = new GetIntersectionNode();


		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);

		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node3;
		//		LinkedList_RemoveDupNode.remove_duplicates(head);
		ListNode result = test.getIntersectionNode2(node1);
		System.out.print("result=====> "+result.val);
	}

}
