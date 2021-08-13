package algo.leetcode;

public class LC0147insertionSortList {

	public static ListNode insertionSortList(ListNode head) {
		if (head == null) {
			return head;
		}
		
		ListNode sentinel = new ListNode(0);
		sentinel.next = head;
		
		ListNode lastSorted = head, cur = head.next;
		
		
		while(cur != null) {
			if (lastSorted.val <= cur.val) {
				lastSorted = cur;
				
			} else {
				ListNode pre = sentinel;
				while(pre.next.val <= cur.val) {
					pre = pre.next;
				}
				
				lastSorted.next = cur.next;
				cur.next = pre.next;
				pre.next = cur;
				
			}
			cur = lastSorted.next;
		}
		
		return sentinel.next;
		
	}

	public static void main(String[] args) {
		ListNode ln1 = new ListNode(1);
		ListNode ln2 = new ListNode(2);
		ListNode ln3 = new ListNode(3);
		ListNode ln4 = new ListNode(4);

		ln1.next = ln2;
		ln2.next = ln3;
		ln3.next = ln4;
		
		LC0147insertionSortList.insertionSortList(ln1);

		ListNode dummy = ln1;

		System.out.println(dummy.next.val);
		ln1.next = ln4;
		System.out.println(dummy.next.val);

	}

}
