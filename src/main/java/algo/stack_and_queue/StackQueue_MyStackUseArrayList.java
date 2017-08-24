package algo.stack_and_queue;

import java.util.ArrayList;

public class StackQueue_MyStackUseArrayList {
	private ArrayList<Object> list = new ArrayList<>();

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public int getSize() {
		return list.size();
	}

	public Object peek() {
		return list.get(getSize() - 1);
	}

	public Object pop() {
		Object o = list.get(getSize() - 1);
		list.remove(getSize() - 1);
		return o;
	}

	public void push(Object o) {
		list.add(o);
	}

	@Override /** Override the toString in the Object class */
	public String toString() {
		return "stack: " + list.toString();
	}
	
	
	public static void main(String[] args){
		StackQueue_MyStackUseArrayList myStack = new StackQueue_MyStackUseArrayList();
		myStack.push("1");
		myStack.push("2");
		
		System.out.println(myStack.toString());
		
		while(!myStack.isEmpty()){
			System.out.println(myStack.pop());
		}
		
	}
}
