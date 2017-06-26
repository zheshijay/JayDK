package algo.linkedlist;

public class MergeTwoLists {
	

	public Node mergeTwoLists(Node l1, Node l2) {
	    Node head = new Node(0);
	    Node p=head;
	 
	    Node p1=l1;
	    Node p2=l2;
	    
	    while(p1!=null && p2!=null){
	        if(p1.val < p2.val){
	            p.next = p1;
	            p1 = p1.next;
	        }else{
	            p.next = p2;
	            p2 = p2.next;
	        }
	        p=p.next;
	    }
	 
	    if(p1!=null){
	        p.next = p1;
	    }
	 
	    if(p2!=null){
	        p.next = p2;
	    }
	 
	    return head.next;
	}
	
	
	
	
	
	
//	Merge 2 linkedlist
	public Node mergeTwoLinkedList(Node head1, Node head2){

	   
	   Node dummy = new Node(0);
	   Node runner = new Node(0);
	   dummy=runner;
	   
	   while(head1!=null && head2!=null){
		   if(head1.val < head2.val){
				runner.next = head1; runner=head1; head1=head1.next;
			}
		   else {
				runner.next = head2; runner=head2; head2=head2.next;
			}
		}
	   
		//merge the rest of the elements from longer list
	     while(head1!=null){
	           runner.next=head1;
		   runner = head1;
	           head1 = head1.next;
		}

	  while(head2!=null){
	           runner.next=head2;
		   runner = head2;
	           head2 = head2.next;
		}

	return dummy.next;


	}
	
	
	public static void main(String[] args){

		MergeTwoLists test = new MergeTwoLists();


		Node node1 = new Node(1);
		Node node3 = new Node(3);
		Node node5 = new Node(5);
		Node node7 = new Node(7);
		Node node9 = new Node(9);
		
		Node node2 = new Node(2);
		Node node4 = new Node(4);
		Node node6 = new Node(6);
		Node node8 = new Node(8);

		node1.next = node3;
		node3.next = node5;
		node5.next = node7;
		node7.next = node9;
		
		
		node2.next = node4;
		node4.next = node6;
		node6.next = node8;
		
//		node5.next = node3;
		//		LinkedList_RemoveDupNode.remove_duplicates(head);
		Node result = test.mergeTwoLinkedList(node1, node2);
		LinkedListUtil.printNode(result);
		

	}
}
