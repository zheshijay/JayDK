package algo.stack_and_queue;

import java.util.LinkedList;
import java.util.List;

public class StackQueue_QueueUseLinkedList {
	private LinkedList list = new LinkedList();
	public void enqueue(Object item) {
		list.addLast(item);
	}
	public Object dequeue() {
		return list.poll();
	}
	public boolean hasItems() {
		return !list.isEmpty();
	}
	public int size() {
		return list.size();
	}
	public void addItems(Object q) {
		list.addLast(q);
	}
	
	public static void main(String[] args){
		StackQueue_QueueUseLinkedList myQueue = new StackQueue_QueueUseLinkedList();
		myQueue.enqueue("1");
		myQueue.enqueue("2");
		
		System.out.println(myQueue.toString());
		
		while(myQueue.hasItems()){
			System.out.println(myQueue.dequeue());
			System.out.println("myQueue size: " + myQueue.size());
		}
		
	}
}
