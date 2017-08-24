package leetcode;


import algo.btree.Node2;

public class ReverseLinkedList {
	Node2 head;
	
	public void reverseList(Node2 curr) {
		System.out.println("current node is: " + curr.val);
		
		if(curr==null) return;  
		if(curr.next==null){
			head = curr;
			return;
		}
		
		reverseList(curr.next);
		curr.next.next = curr;
		curr.next = null;

	}  
	
	
	public void reverseListRecursive(){
		Node2 node1 = new Node2(1);
		Node2 node2 = new Node2(2);
		Node2 node3 = new Node2(3);
		Node2 node4 = new Node2(4);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		head = node1;
		reverseList(head);
		
//		System.out.println("head val: " + head.val);

		Node2 cur = head.next;
		while(cur.hasNext()){
			cur = cur.next;
			System.out.println(cur.val);
		}
	}


	public static void main(String[] args) {
		ReverseLinkedList test = new ReverseLinkedList();
		test.reverseListRecursive();
		
	}

}
