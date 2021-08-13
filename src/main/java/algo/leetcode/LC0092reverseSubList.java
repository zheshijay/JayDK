package algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC0092reverseSubList {
	// 翻转n个节点，返回新链表的头部
    private ListNode reverseN(ListNode head, int n) {
        ListNode prev = null;
        ListNode curr = head;
        for (int i = 0; i < n; i++) {
            ListNode oldNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = oldNext;
        }
        return prev;
    }
    
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(42);
        dummy.next = head;
        ListNode ptr1 = dummy;
        ListNode ptr2 = dummy;
        // 找到左右两段的端点
        for (int i = 0; i < m - 1; i++) {
            ptr2 = ptr2.next;
        }
        for (int i = 0; i < n + 1; i++) {
            ptr1 = ptr1.next;
        }
        // 找到中段的尾端点
        ListNode t = ptr2.next;
        // 翻转中段，得到中段的头端点
        ListNode h = reverseN(t, n - m + 1);
        // 中端的头端点和左段端点相连
        ptr2.next = h;
        // 中段的尾端点和右段端点相连
        t.next = ptr1;
        return dummy.next;
    }

	// Driver code
	public static void main(String args[]) {
		LC0092reverseSubList test = new LC0092reverseSubList();

		int[] nums = new int[] { 4, 3, 2, 7, 8, 2, 3, 1 };

		List<Integer> res = test.findDuplicates(nums);
		System.out.println("res:" + res);
	}
}
