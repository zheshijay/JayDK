package algo.linkedlist;

public class PartitionLinkedList {

/*
给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
你应当保留两个分区中每个节点的初始相对位置。

 

示例:

输入: head = 1->4->3->2->5->2, x = 3
输出: 1->2->2->4->3->5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/partition-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
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


	public ListNode partition(ListNode head, int x) {
		
		ListNode dummy1 = new ListNode(0);   // use dummy1 to return the final res
		ListNode dummy2 = new ListNode(0);   //use dummy2 to connect dummy1
		
		ListNode p1 = dummy1;
		ListNode p2 = dummy2;
		
		while(head!=null){
			
			if(head.val < x){   //put all number less than x to dummy1
				p1.next = head;
				p1 = head;    //move pointer to next index
			}else{ //put all number greater than x to dummy2
				p2.next = head;
				p2 = head;    //move pointer to next index
			}
			
			head = head.next;
		}
		
		//Conect 2 dummy list
		p1.next = dummy2.next;
		p2.next = null;  //avoid infinite loop
		
		return dummy1.next;
	}



	public static void main(String[] args){
		PartitionLinkedList test = new PartitionLinkedList();

		ListNode Node1 = new ListNode(1);
		ListNode Node2 = new ListNode(4);
		ListNode Node3 = new ListNode(3);
		ListNode Node4 = new ListNode(2);
		ListNode Node5 = new ListNode(5);
		ListNode Node6 = new ListNode(2);

		Node1.next = Node2;
		Node2.next = Node3;
		Node3.next = Node4;
		Node4.next = Node5;
		Node5.next = Node6;
		//		Node5.next = null;

		System.out.println("-- before");
		System.out.println(Node1);

		ListNode newNodeList = test.partition(Node1, 3);
		System.out.println("");
		System.out.println("-- after");
		System.out.println(newNodeList);

		//		test.printList(test.reversedList(Node1));		


	

	}
}
