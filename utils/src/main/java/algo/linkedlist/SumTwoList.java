package algo.linkedlist;

import java.util.HashMap;
import java.util.Stack;

public class SumTwoList {

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}


	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		HashMap<Integer, Integer> hm1 = new HashMap<Integer, Integer>(); //Store the 'index' and the value of List1
		HashMap<Integer, Integer> hm2 = new HashMap<Integer, Integer>(); //Store the 'index' and the value of List2

		int i = 1, j = 1;

		while(l1 != null){
			hm1.put(i, l1.val);
			l1 = l1.next;
			i++;
		}
		while(l2 != null){
			hm2.put(j, l2.val);
			l2 = l2.next;
			j++;
		}

		int carry = 0;
		i--; j--;
		ListNode head = null;

		//Create new nodes to the front of a new LinkedList
		while(i > 0 || j > 0 || carry > 0){

			int a = i > 0 ? hm1.get(i) : 0;
			int b = j > 0 ? hm2.get(j) : 0;

			int res = (a + b + carry) % 10;  //get remainder use modulus operator

			ListNode newNode = new ListNode(res);    //create node and assign value
			newNode.next = head;
			head = newNode;

			carry = (a + b + carry) / 10;  //calculate carry 
			System.out.println("--> carry is: " + carry);
			i--; j--;
		}
		return head;
	}

	public void printList(ListNode node ){
		while(node!=null){
			System.out.print(node.val);
			node = node.next;
		}
	}
	
	public ListNode myAddTwoNumbers(ListNode node1, ListNode node2){
		
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		
		while(node1!=null){
			s1.push(node1.val);
			node1 = node1.next;
		}
		
		while(node2!=null){
			s2.push(node2.val);
			node2 = node2.next;
		}
		
		int carry =0;

		ListNode head = null;
		
		while(!s1.isEmpty() || !s2.isEmpty() || carry!=0){
		    System.out.println("s1:" + s1);
		    System.out.println("s2:" + s2);
			int sum = 0;
			    if (!s1.empty()) sum += s1.pop();
	            if (!s2.empty()) sum += s2.pop();
	            
	            sum+=carry;
	            
	            System.out.println("sum:" + sum);
	            int newNodeValue = sum % 10;
	            
	            System.out.println("create new node: " + newNodeValue);
	            //create new node
	            ListNode newNode = new ListNode(newNodeValue);
	            newNode.next = head;
	            head = newNode;
	            carry = sum /10;
		}
		return head;
	}
	

	public static void main(String[] args){
		SumTwoList sumTwoList = new SumTwoList();
		ListNode node1 = new ListNode(1);
		ListNode node5 = new ListNode(5);
		ListNode node8 = new ListNode(8);

		ListNode node2 = new ListNode(8);
		ListNode node3 = new ListNode(4);
		ListNode node4 = new ListNode(4);

		node1.next = node5;
		node5.next = node8;

		node2.next = node3;
		node3.next = node4;

		ListNode res = sumTwoList.myAddTwoNumbers(node1, node2);
		sumTwoList.printList(res);
	} 
}
