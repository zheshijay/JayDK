package algo.linkedlist;


/**
 * http://bangbingsyb.blogspot.com/2014/11/leetcode-intersection-of-two-linked.html
 * 

1. if two linkedlist has intersection, they must have the same end.

 Steps:
      (1) check if they has the same end value (ailA==tailB)
      (2) if they has intersection, find the DIFF abs(lenA-lenB), let the longer one runs DIFF steps
      (3) Then move 2 pointer same time and compare both value, return one of the Node when value are equal.

 * @author ZShi
 *
 */
public class IntersectionLinkedList {
	static class Node {
		int val;
		Node next;
		Node(int x) { val = x; }
	}

	public Node getIntersectionNode(Node headA, Node headB) {
		
		int lenA =0, lenB=0;
		
	    Node pA=headA, pB=headB;
	    
	    if (pA == null || pB == null)
            return null;
 
		while(pA!=null){
			lenA++;
			pA=pA.next;
		}
		
		while(pB!=null){
			lenB++;
			pB=pB.next;
		}
		
		if(pA!=pB) return null;
		else{
			
			Node pAHead=headA, pBHead=headB;
			
			int diff = Math.abs(lenA-lenB);
			if(lenA>lenB){
				int i=0;
				while(i<diff){
					pAHead = pAHead.next;
					i++;
				}
			}else{
				int i=0;
				while(i<diff){
					pBHead = pBHead.next;
					i++;
				}
			}

			while(pAHead !=null && pBHead!=null){
				if(pAHead.val == pBHead.val) return pAHead;
				else {
					pAHead=pAHead.next;
					pBHead=pBHead.next;
				}
			}

		}
		
		return null;
		
	}



public static void main(String[] args){

	IntersectionLinkedList test = new IntersectionLinkedList();
	
	Node node1 = new Node(1);
	Node node2 = new Node(2);
	Node node3 = new Node(3);
	Node node4 = new Node(4);
	Node node5 = new Node(5);

	Node nodeA = new Node(9);
	Node nodeB = new Node(8);
	Node nodeC = new Node(3);
	Node nodeD = new Node(4);
	Node nodeE = new Node(5);

	node1.next = node2;
	node2.next = node3;
	node3.next = node4;
	node4.next = node5;

	nodeA.next = nodeB;
	nodeB.next = nodeC;
	nodeC.next = nodeD;
	nodeD.next = nodeE;

	//		LinkedList_RemoveDupNode.remove_duplicates(head);
	Node result = test.getIntersectionNode(node1, nodeA);

	if(result!=null)
		System.out.print("result=====> "+result.val);
	else{
		System.out.print("result=====> "+result);
	}
}

}
