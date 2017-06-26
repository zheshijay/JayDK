package algo.linkedlist;


public class LinkedListUtil {

	public static void printNode(Node head){
		while(head!=null){
			System.out.print(head.val + "->");
			head = head.next;
			
		}
	}
}
