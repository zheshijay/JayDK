package algo.leetcode;

import java.util.Stack;

public class LC0302MinStack {
	//sol 1:
	 int min = Integer.MAX_VALUE;
	    Stack<Integer> stack = new Stack<>();

	    public void push(int x) {
	        //如果加入的值小于最小值，要更新最小值
	        if (x <= min) {
	            stack.push(min);
	            min = x;
	        }
	        stack.push(x);
	    }

	    public void pop() {
	        //如果把最小值出栈了，就更新最小值
	        if (stack.pop() == min)
	            min = stack.pop();
	    }

	    public int top() {
	        return stack.peek();
	    }

	    public int getMin() {
	        return min;
	    }
	
	// sol 2:
//		Deque<Integer> xStack;
//	    Deque<Integer> minStack;
//
//	    public LC0302MinStack() {
//	        xStack = new LinkedList<Integer>();
//	        minStack = new LinkedList<Integer>();
//	        minStack.push(Integer.MAX_VALUE);
//	    }
//	    
//	    public void push(int x) {
//	        xStack.push(x);
//	        minStack.push(Math.min(minStack.peek(), x));
//	    }
//	    
//	    public void pop() {
//	        xStack.pop();
//	        minStack.pop();
//	    }
//	    
//	    public int top() {
//	        return xStack.peek();
//	    }
//	    
//	    public int getMin() {
//	        return minStack.peek();
//	    }

	public static void main(String[] args) {
		LC0302MinStack minStack = new LC0302MinStack();
		minStack.push(3);
		
		minStack.push(5);

		
		System.out.println(minStack.top());
//		minStack.getMin();
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.top());
//		System.out.println(minStack.getMin());
		
	}
}
