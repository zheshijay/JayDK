package algo.stack_and_queue;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Queue_Use {
	public static void main(String args[]){
		 Queue queue = new LinkedList();
	        //add key-value pair to Hashtable
		 queue.offer("one");
		 queue.offer("two");
		 queue.offer("three");
		 
		 while(!queue.isEmpty()){
			 System.out.println("value: " + queue.poll());
		 }
	      
	}
}
