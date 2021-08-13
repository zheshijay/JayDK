package algo.jianzhioffer;


public class ListNodeUtil {
	int val;
	ListNodeUtil next = null;

	public ListNodeUtil() {}
	
	public ListNodeUtil(int val) {
		this.val = val;
	}
	
	public static void printNodes(ListNode node) {
		while(node!= null) {
			System.out.print(node.val + " -> ");
			node = node.next;
		}
	}
}
