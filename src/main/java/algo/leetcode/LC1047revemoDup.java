package algo.leetcode;

import java.util.Stack;

public class LC1047revemoDup {

	public String removeDuplicates(String S) {
		Stack<Character> stack = new Stack<>();
		for (char c : S.toCharArray()) {

			if (stack.isEmpty() || stack.peek() != c) {
				System.out.println("adding:" + c);
				stack.add(c);
			} else {
				System.out.println("----> pop:" + stack);
				stack.pop();
				System.out.println("----> after pop:" + stack);
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.reverse().toString();
	}

	public String removeDuplicates2(String S) {
		StringBuilder sb = new StringBuilder();
		for (char c : S.toCharArray()) {
			if (sb.length() == 0 || sb.charAt(sb.length() - 1) != c) {
				sb.append(c);
			} else {
				sb.deleteCharAt(sb.length() - 1);
			}
		}
		return sb.toString();
	}

	// Driver code
	public static void main(String args[]) {
		LC1047revemoDup test = new LC1047revemoDup();

		System.out.println("res:" + test.removeDuplicates2("abbcde"));
	}
}
