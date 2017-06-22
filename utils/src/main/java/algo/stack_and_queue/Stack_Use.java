package algo.stack_and_queue;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Stack_Use {
	public static void main(String args[]){
		 Stack stack = new Stack();
	        //add key-value pair to Hashtable
		 stack.push("one");
		 stack.push("two");
		 stack.push("three");
		 
		 while(!stack.isEmpty()){
			 System.out.println("value: " + stack.pop());
		 }
	      
	}
}
