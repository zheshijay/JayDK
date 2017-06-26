package algo.stack_and_queue;

import java.util.ArrayList;
import java.util.List;

public class MyStackUseList<T> {
	
	List<T> list = new ArrayList<>();
	
	public void push(T obj){
		list.add(obj);
	}
	
	public Object pop(){
		Object obj = list.get(list.size()-1);
		list.remove(list.size()-1);
		return obj;
	}
	
	public boolean isEmpty(){
		if(list.size()>0) return false;
		return true;
		
	}
	
	public static void main(String[] args){
		int a=1,b=2,c=3;
		
		MyStackUseList stack = new MyStackUseList();
		
		stack.push(a);
		stack.push(b);
		stack.push(c);
		
		
		while(!stack.isEmpty()){
			System.out.print(stack.pop());
		}
		
		
		
		
		
		
	}
	


}
