
public class _CodeFormatter {

	/*
	 * // Definition for a Node. class Node { public int val; public Node prev;
	 * public Node next; public Node child; };
	 */

	class Solution {
		public Node flatten(Node head) {
			if (head == null)
				return head;

			Node sentinel = new Node(0, null, head, null);
			Node cur, pre = sentinel;

			Deque<Node> stack = new ArrayDeque<>();
			stack.push(head);

			while (!stack.isEmpty()) {
				cur = stack.pop();
				pre.next = cur;
				cur.prev = pre;
				pre = cur;

				if (cur.next != null) {
					stack.push(cur.next);
				}

				if (cur.child != null) {
					stack.push(cur.child);
					cur.child = null;
				}

			}

			sentinel.next.prev = null;
			return sentinel.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
