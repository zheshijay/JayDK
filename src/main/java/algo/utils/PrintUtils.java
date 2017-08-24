package algo.utils;

import algo.linkedlist.Node;

public class PrintUtils {
	public static void printTwoDArray(Object[][] a){

		for(int row=0; row< a.length; row++){
			for(int col=0; col < a[row].length; col++){
				System.out.print(a[row][col]+ " ");
			}
			System.out.println();
		}
	}
	
	public static void printTwoDArray(int[][] a){

		for(int row=0; row< a.length; row++){
			for(int col=0; col < a[row].length; col++){
				System.out.print(a[row][col]+ " ");
			}
			System.out.println();
		}
	}

	public static void printTwoDArray(boolean[][] a){

		for(int row=0; row< a.length; row++){
			for(int col=0; col < a[row].length; col++){
				System.out.print(a[row][col]+ " ");
			}
			System.out.println();
		}
	}
	
	public static void printLinkedListNode(Node head){

		String vals = "";
		Node dummy = head;
		while(dummy!=null){
			vals += dummy.val + "->";
			dummy = dummy.next;
		}
		System.out.println(vals);
	}
}
