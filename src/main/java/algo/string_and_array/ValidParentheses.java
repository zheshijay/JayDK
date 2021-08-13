package algo.string_and_array;

import java.util.Stack;

public class ValidParentheses {

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		
		System.out.println("stack: "+ stack);
		System.out.println("stack.isEmpty(): "+ stack.isEmpty());
		return stack.isEmpty();
	}


	public static void main(String args[]){
		ValidParentheses test = new ValidParentheses();
		System.out.println(test.isValid("())"));


	}
}
