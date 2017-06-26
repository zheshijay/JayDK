package algo.linkedlist;


public class CycleRemove {
	
	public Node deleteCycle(Node head){
		
		if(head==null) return null;

		
		//find the meet pointer when detect the cycle
		Node slow = head, fast=head;

		while(fast.next!=null && fast.next.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast) break;
		}
		
		System.out.println(" meet at " + fast.val);
		
		//move slow to the start of list
		
		Node dummy = new Node(0);
		dummy.next = fast;
		fast=dummy;
		slow= head;
		System.out.println("slow " + slow.val);
		System.out.println("fast " + fast.next.val);
		
		while(slow.next!=null && fast.next.next!=null){
		
			System.out.println("fast.next  " + fast.next);
			if(slow==fast.next) {  //break the link
				
				System.out.println("find start node : " + fast.val);
				
				fast.next = null; break;
			}else{
				System.out.println("slow: "+ slow.next.val + " fast:" + fast.val);
				slow=slow.next;
				fast=fast.next;
			}
		}
		
		

		return head;  //return either slow or fast
	}
	
	

	
	
	public static void main(String[] args){

		CycleRemove test = new CycleRemove();

		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);

		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node3;
		//		LinkedList_RemoveDupNode.remove_duplicates(head);
		Node result = test.deleteCycle(node1);
		LinkedListUtil.printNode(result);
	}

}
