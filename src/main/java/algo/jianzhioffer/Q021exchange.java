package algo.jianzhioffer;

/*

输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。

示例：

给定一个链表: 1->2->3->4->5, 和 k = 2.

返回链表 4->5.

 */

public class Q021exchange {
	/*
	 * 2 pointers
	 */
	public ListNode getKthFromEnd(ListNode head, int k) {
		ListNode p1, p2;
		p1 = head;
		p2 = head;
		int i=0;
		while(i < k -1) {
			p2 = p2.next;
			i++;
			System.out.println("i:" + i);
		}
		
		while(p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return p1;
		
    }
	
	
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		Q021exchange test = new Q021exchange();
		
		ListNode resNode = test.getKthFromEnd(n1, 3);
		
		ListNodeUtil.printNodes(resNode);
	}

}