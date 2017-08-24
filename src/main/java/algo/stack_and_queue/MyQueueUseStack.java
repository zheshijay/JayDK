package algo.stack_and_queue;

import java.util.NoSuchElementException;
import java.util.Stack;

public class MyQueueUseStack<T> {
    private Stack<T> stack1;   
    private Stack<T> stack2;  

    // create an empty queue
    public MyQueueUseStack() {
        stack1 = new Stack<T>();
        stack2 = new Stack<T>();
    }

    // move all items from stack1 to stack2
    private void moveStack1ToStack2() {
        while (!stack1.isEmpty())
            stack2.push(stack1.pop());
    }

    // is the queue empty?
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }


    // return the number of items in the queue.
    public int size() {
        return stack1.size() + stack2.size();     
    }

    // return the item least recently added to the queue.
    public T front() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        if (stack2.isEmpty()) moveStack1ToStack2();
        return stack2.peek();
    }

    // add the item to the queue
    public void enqueue(T item) {
        stack1.push(item);
    }

    // remove and return the item on the queue least recently added
    public T dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        if (stack2.isEmpty()) moveStack1ToStack2();
        return stack2.pop();
    }


    // a test client
    public static void main(String[] args) {
    	
    }
}
