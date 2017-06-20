package qa;

public class MySumLinkedList {

	public ListNode sumTwoList(ListNode l1, ListNode l2 ){ 
		ListNode dummyHead = new ListNode(0);
		ListNode p = l1, q = l2, curr = dummyHead;
		int carry = 0;
		while (p != null || q != null) {
			int x = (p != null) ? p.val : 0;
			int y = (q != null) ? q.val : 0;
			int sum = carry + x + y;
			carry = sum / 10;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			if (p != null) p = p.next;
			if (q != null) q = q.next;
		}
		if (carry > 0) {
			curr.next = new ListNode(carry);
		}
		return dummyHead.next;
		}




	public static class ListNode{
		int val;
		ListNode next;

		ListNode(int val){
			this.val = val;
			this.next = null;
		}	
		
		boolean hasNext(){
		if(this.next!=null) return true;
		return false;
		}
	}

	/**
	 * @param args
	 */
	 public static void main(String[] args) {
		 ListNode node1 = new ListNode(1);
		 ListNode node2 = new ListNode(1);
		 ListNode node3 = new ListNode(1);

		 ListNode node4 = new ListNode(4);
		 ListNode node5 = new ListNode(5);
		 ListNode node6 = new ListNode(6);

		 node1.next = node2;
		 node2.next = node3;

		 node4.next = node5;
		 node5.next = node6;
		 
		 
		 System.out.println("node4.next: " + node4.next);
		 System.out.println("node5.next: " + node5.next);
		 System.out.println("node6.next: " + node6.next);

		 ListNode l1 = new ListNode(0);
		 ListNode l2 = new ListNode(0);
		 l1.next = node1;
		 l2.next = node4;

		 MySumLinkedList mysum = new MySumLinkedList();
		 ListNode sumList =  mysum.sumTwoList(l1, l2);
		 
		 
		 ListNode head = new ListNode(0);
		 head = sumList;
		 while(head.hasNext()){
			 ListNode currtNode = head.next;
			 head = head.next;
			 
			 System.out.println("hasNext : "+ (sumList.hasNext()) );
			 System.out.println("currtNode : "+currtNode.val);
		 }


	 }

}
