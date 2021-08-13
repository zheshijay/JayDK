package algo.jianzhioffer;

/*

输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

示例1：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
限制：

0 <= 链表长度 <= 1000

 */

public class Q025mergeTwoLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode p1 = l1, p2 = l2;
		ListNode p3 = new ListNode();
		ListNode newHead = p3;

		while (p1 != null && p2 != null) {
			System.out.println("p1:" + p1.val + " - p2:" + p2.val);
			
			
			if (p1.val <= p2.val) {
				
				System.out.println("1 adding:" + p1.val);
				
				p3.next = new ListNode(p1.val);
				p1 = p1.next;
			} else {
				System.out.println("2 adding:" + p2.val);
				p3.next = new ListNode(p2.val);
				p2 = p2.next;
			}
			p3 = p3.next;
		}
		
		ListNode rest = p1 == null? p2:p1;
		
		while(rest != null) {
			p3.next = new ListNode(rest.val);
			p3 = p3.next;
			rest=rest.next;
		}

		return newHead.next;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n4;

		ListNode ln1 = new ListNode(1);
		ListNode ln3 = new ListNode(3);
		ListNode ln4 = new ListNode(4);
		ln1.next = ln3;
		ln3.next = ln4;

		Q025mergeTwoLists test = new Q025mergeTwoLists();

		ListNode resNode = test.mergeTwoLists(n1, ln1);

		ListNodeUtil.printNodes(resNode);
	}

}