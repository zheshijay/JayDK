package algo.linkedlist;

import java.util.HashMap;
import java.util.Stack;

public class SumTwoList {


	public Node addTwoNumbers(Node l1, Node l2) {

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
		Node head = null;

		//Create new nodes to the front of a new LinkedList
		while(i > 0 || j > 0 || carry > 0){

			int a = i > 0 ? hm1.get(i) : 0;
			int b = j > 0 ? hm2.get(j) : 0;

			int res = (a + b + carry) % 10;  //get remainder use modulus operator

			Node newNode = new Node(res);    //create node and assign value
			newNode.next = head;
			head = newNode;

			carry = (a + b + carry) / 10;  //calculate carry 
			System.out.println("--> carry is: " + carry);
			i--; j--;
		}
		return head;
	}

	public void printList(Node node ){
		while(node!=null){
			System.out.print(node.val);
			node = node.next;
		}
	}

	public Node myAddTwoNumbers(Node node1, Node node2){

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

		Node head = null;

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
			Node newNode = new Node(newNodeValue);
			newNode.next = head;
			head = newNode;
			carry = sum /10;
		}
		return head;
	}













	public Node twoSumList(Node head1, Node head2){
		//1. push to stack
		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();

		while(head1!=null){
			stack1.push(head1);
			head1=head1.next;
		}
		while(head2!=null){
			stack2.push(head2);
			head2=head2.next;
		}
		
		System.out.println("stack1 is: " + stack1);
		System.out.println("stack2 is: " + stack2);
		

		//2. pop up values and compare, create new node and connect to result list
		int career =0;
		Node res = null;
		while(!stack1.isEmpty() && !stack2.isEmpty() ){
			
			Node node1 = stack1.pop();
			Node node2 = stack2.pop();

			Node newNode =  new Node((node1.val + node2.val + career) % 10);
			
			career =  (node1.val + node2.val + career) / 10;	

			//link to result
			newNode.next = res;
			res=newNode; 	
		}

		while(!stack1.isEmpty()){
			Node node1 = stack1.pop();
			Node newNode =  new Node( (node1.val + career) % 10 );
			career =  (node1.val + career) / 10;	
			newNode.next = res;
			res=newNode; 	
			career =0;
		}

		while(!stack2.isEmpty()){
			Node node2 = stack2.pop();
			Node newNode =  new Node( (node2.val + career) % 10 );
			career =  (node2.val + career) / 10;	
			newNode.next = res;
			res=newNode; 	
			career =0;
		}

		if(career > 0){
			Node newNode =  new Node( career );
			newNode.next = res;
			res=newNode; 	
		}
		
		return res;
	}










	public static void main(String[] args){
		SumTwoList sumTwoList = new SumTwoList();
		Node node1 = new Node(7);
		Node node5 = new Node(5);
//		Node node8 = new Node(8);

		Node node2 = new Node(2);
		Node node3 = new Node(7);
		Node node4 = new Node(0);

		node1.next = node5;
//		node5.next = node8;

		node2.next = node3;
		node3.next = node4;

		Node res = sumTwoList.twoSumList(node1, node2);
		LinkedListUtil.printNode(res);

		
	} 
}
