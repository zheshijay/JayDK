package algo.jianzhioffer;

/*

定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

 

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
 

限制：

0 <= 节点个数 <= 5000


 */

public class Q024reverseList {
	public ListNode reverseList(ListNode head) {
		if (head == null) return head;
		
		ListNode pre, cur, next;
		
		pre = null;
		cur = head;
		
		while(cur != null) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		
		return pre;
		
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
		
		Q024reverseList test = new Q024reverseList();
		
		ListNode resNode = test.reverseList(n1);
		
		ListNodeUtil.printNodes(resNode);
	}

}