package algo.linkedlist;

import algo.utils.PrintUtils;

/*
给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: 1->2->3->4->5->NULL, k = 2
输出: 4->5->1->2->3->NULL
解释:
向右旋转 1 步: 5->1->2->3->4->NULL
向右旋转 2 步: 4->5->1->2->3->NULL
示例 2:

输入: 0->1->2->NULL, k = 4
输出: 2->0->1->NULL
解释:
向右旋转 1 步: 2->0->1->NULL
向右旋转 2 步: 1->2->0->NULL
向右旋转 3 步: 0->1->2->NULL
向右旋转 4 步: 2->0->1->NULL

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rotate-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RotateLinkedlist {
	/*
	 * 
	 * Example: Inputs: 1->2->3->4->5->6->7->8->NULL and k = 3 Output:
	 * 3->2->1->6->5->4->8->7->NULL.
	 * 
	 * Inputs: 1->2->3->4->5->6->7->8->NULL and k = 5 Output:
	 * 5->4->3->2->1->8->7->6->NULL.
	 * 
	 */
	public ListNode rotateRight(ListNode head, int k) {
		// base cases
		if (head == null)
			return null;
		if (head.next == null)
			return head;

		// close the linked list into the ring
		ListNode old_tail = head;
		int n;
		for (n = 1; old_tail.next != null; n++)
			old_tail = old_tail.next;
		old_tail.next = head;

		// find new tail : (n - k % n - 1)th node
		// and new head : (n - k % n)th node
		ListNode new_tail = head;
		for (int i = 0; i < n - k % n - 1; i++)
			new_tail = new_tail.next;
		ListNode new_head = new_tail.next;

		// break the ring
		new_tail.next = null;

		return new_head;
	}

	public static void main(String[] args) {
		RotateLinkedlist test = new RotateLinkedlist();

		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		// Node5.next = null;

		Node head = node1;

		System.out.println(" original: ");
		PrintUtils.printLinkedListNode(head);

		System.out.println(" reversed: ");
		PrintUtils.printLinkedListNode(test.reverse(head, 2));

	}

}
