package algo.linkedlist;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class RemoveDuplicateNode {

	public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return head;
        }
        Set<Integer> occurred = new HashSet<Integer>();
        occurred.add(head.val);
        ListNode pos = head;
        // 枚举前驱节点
        while (pos.next != null) {
            // 当前待删除节点
            ListNode cur = pos.next;
            if (occurred.add(cur.val)) {
                pos = pos.next;
            } else {
                pos.next = pos.next.next;
            }
        }
        pos.next = null;
        return head;
    }
	
	 public ListNode removeDuplicateNodes2(ListNode head) {
	        ListNode ob = head;
	        while (ob != null) {
	            ListNode oc = ob;
	            while (oc.next != null) {
	                if (oc.next.val == ob.val) {
	                	System.out.println("removing:" + oc.val);
	                    oc.next = oc.next.next;
	                } else {
	                    oc = oc.next;
	                }
	            }
	            ob = ob.next;
	        }
	        return head;
	    }


	public static void main(String[] args){
		RemoveDuplicateNode test = new RemoveDuplicateNode();

		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(2);
		ListNode node6 = new ListNode(1);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;

		ListNode head = node1;

		test.removeDuplicateNodes(head);

		while(head!=null){
			System.out.print(head.val);
			head = head.next;
			//			 System.out.print(node1.data);
		}

	}

}
