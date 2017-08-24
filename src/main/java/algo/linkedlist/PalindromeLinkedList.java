package algo.linkedlist;

import java.util.Stack;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * @author ZShi
 *
 */
public class PalindromeLinkedList {

	//Use stack
	public boolean isPalindrome(Node head){
		Stack<Node> stack = new Stack<Node>();

		Node nodePointer = head;
		Node headNode = head;

		//push to stack
		while(nodePointer!=null){
			stack.push(nodePointer);
			nodePointer = nodePointer.next;
		}

		//compare
		while(!stack.isEmpty()){
			Node eachNode = stack.pop();
			Node oriNode = headNode;
			if(eachNode.val != oriNode.val) return false;
			headNode=headNode.next;

		}
		return true;
	}

	//use two pointer
	public boolean isPalindrome2(Node head) {
		if(head == null || head.next == null) return true;
		Node fast = head;
		Node slow = head;
		// 寻找中点
		while(fast.next != null && fast.next.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		// 记录第二段链表的第一个节点
		Node secondHead = slow.next;


		Node p1 = secondHead;
		Node p2 = p1.next;
		// 将第一段链表的尾巴置空
		slow.next = null;
		while(p1 != null && p2 != null){
			Node tmp = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = tmp;
		}

		// 将第二段链表的尾巴置空
		secondHead.next = null;

		System.out.println("head");
		LinkedListUtil.printNode(head);

		System.out.println();
		System.out.println("p1");
		LinkedListUtil.printNode(p1);


		// 依次判断
		while(p1 != null){
			if(head.val != p1.val) return false;
			head = head.next;
			p1 = p1.next;
		}
		return true;
	}

	public boolean isPalindrome3(Node head){

		//1. Find the mid point
		Node slow = head, fast = head;

		while(fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}
		Node mid = slow;

		//2. reverse the right side
		Node rightHead = mid.next;
		Node pre = null, cur=rightHead, next;
		while(cur!=null){
			next = cur.next;
			cur.next = pre;
			pre=cur;
			cur=next;
		}   //now we got pre as the head of the right side reversed list
		
		System.out.println("head");
		LinkedListUtil.printNode(head);

		System.out.println();
		System.out.println("pre");
		LinkedListUtil.printNode(pre);
		
		
		//3. Compare two list ( use right side list in while loop, because the right side is <= left side  E.g.  1->3->5  VS 3->1  )
		while(pre!=null){
			if(head.val != pre.val) return false;
			else{
				head=head.next;
				pre=pre.next;
			}
		}
		return true;
	}

	public static void main(String[] args){
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(2);
		Node node5 = new Node(1);


		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		PalindromeLinkedList test = new PalindromeLinkedList();

		System.out.println(test.isPalindrome3(node1));



	}


}
