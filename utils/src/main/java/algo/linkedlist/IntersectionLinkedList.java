package algo.linkedlist;

import corejava.datastructure.linkedlist.leetcode.LinkedList_RemoveGivenNode.Node;

/**
 * http://bangbingsyb.blogspot.com/2014/11/leetcode-intersection-of-two-linked.html
 * 
 * 思路�??

找链表交界，很类似Linked List Cycle II那题，方法也是类似的双指针相遇法。分两步走：

1. 如何判断两链表是否相交？
两链表相交则他们必然有共同的尾节点�?�所以遍历两两链表，找到各自的尾节点，如果tailA!=tailB则一定不相交，反之则相交�??

2. 如何判断两链表相交的起始节点�??
在第1步判断相交时可以顺带计算两链表的长度lenA和lenB。让长的链表的head先走abs(lenA-lenB)步，然后和短链表的head�??起走，直到两者相遇，即为要找的节点�??
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
