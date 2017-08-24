package algo.linkedlist;

import java.util.Hashtable;

public class RemoveDuplicationNodes {

	static class Node {
		int val;
		Node next;
		Node(int x) { val = x; }

		public String toString(){
			Node temp = next;

			String vals = "";
			vals+=val+"->";
			while(temp!=null){
				vals+=temp.val+"->";
				temp = temp.next;
			}
			return vals;
		}

	}

	//remove use hashtable
	public Node removeDupNodesUseTable(Node head){
		Hashtable table = new Hashtable();
		Node dummy = new Node(0);
		dummy.next = head;
		head = dummy;

		while(head.next!=null){
			if(table.containsKey(head.next.val)){
				System.out.println("removeing " + head.next.val);
				head.next = head.next.next;
			}else{
				table.put(head.next.val, true);
				head = head.next;
			}
		}
		return dummy.next;
	}
	
	/*
	 * 
	 * 
	 * Remove duplicate nodes (Get Unique Nodes)
	 * 1->2->2->3->4->4->5    ==============>   1->2->3->4->5
	 * 
	 */
		public Node removeDupNodes1(Node head){
			System.out.println("original node is: " + head);
			
			Node dummy = new Node(0);
			dummy.next = head;
			head = dummy;
			
			Node curNode = head.next;
			
			while(head.next!=null && head.next.next!=null){           
				if(head.next.val == head.next.next.val ){
					head.next = head.next.next;      
				}else{                                                         // Move to next index when head.next.val != head.next.next.val;
					System.out.println("--->111 move to next node..." + head);
					head= head.next;   //move on...
				}
			
			}
			return dummy.next;
		}
		
		/*
		 * 
		 * 
		 * Remove duplicate nodes
		 * 1->2->2->3->4->4->5    ==============>   1->3->5
		 * 
		 * and Diffs compare to removeDupNodes1
		 */
			public Node removeDupNodes2(Node head){
				System.out.println("original node is: " + head);
				
				Node dummy = new Node(0);
				dummy.next = head;
				head = dummy;
				
				while(head.next!=null && head.next.next!=null){
					
					if( head.next.val == head.next.next.val ){
						int curVal = head.next.val;               
						
						while(head.next!=null && head.next.val == curVal){
							head.next = head.next.next;                      //remove duplicate values from CURRENT node!!!
						}
						
						
						
						
						
					}else{    // Move to next index, duplicate values already removed
						
						head= head.next;   //move on...
						System.out.println("---> move to next node..." + head);
					}
				
				}
				return dummy.next;
			}
		
		
	public static void main(String[] args){
		RemoveDuplicationNodes test = new RemoveDuplicationNodes();
		Node node1 = new Node(1);
		Node node2 = new Node(1);
		Node node3 = new Node(1);
		Node node4 = new Node(2);
		Node node5 = new Node(3);
		Node node6 = new Node(3);
		Node node7 = new Node(4);
		Node node8 = new Node(5);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;

		Node head = node1;

		System.out.println("original node is: " + head);

//		Node uniqueNodes = test.removeDupNodesUseTable(head);
		Node uniqueNodes = test.removeDupNodes1(head);

		System.out.println("uniqueNodes  is: " + uniqueNodes);

		//		while(uniqueNodes!=null){
		//			System.out.print(uniqueNodes.val);
		//			uniqueNodes = uniqueNodes.next;
		//			//			 System.out.print(node1.data);
		//		}

	}

}
