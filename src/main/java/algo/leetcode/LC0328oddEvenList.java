package algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC0328oddEvenList {
	public ListNode oddEvenList(ListNode head) {

		if (head == null)
			return head;

		ListNode result = head;
		
		

		ListNode p1 = head;
		ListNode p2 = head.next;
		ListNode headOfEvenNode = head.next;

		while (p1.next != null && p2.next != null) {
//	            ListNode t = p2.next;
//	            if(t == null)
//	                break;

			p1.next = p2.next;
			p1 = p1.next;

			p2.next = p1.next;
			p2 = p2.next;
		}

		p1.next = headOfEvenNode;

		return result;

	}

	// Driver code
	public static void main(String args[]) {
		LC0328oddEvenList test = new LC0328oddEvenList();
		int[][] intervals = { { 1, 3 }, { 6, 9 } };
		int[] newInterval = { 2, 5 };

		int[][] res = test.insert(intervals, newInterval);
		System.out.println("res:" + Arrays.deepToString(res));
	}
}
