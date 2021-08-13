package algo.roblox;

import java.util.Deque;
import java.util.LinkedList;

public class LC0227basicCalaulator3 {

	public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<Integer>();
        char preSign = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (Character.isDigit(s.charAt(i))) {
            	System.out.println("nums is:" + num);
                num = num * 10 + s.charAt(i) - '0';
                
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                    	stack.push(stack.pop() / num);
                        break;
                    default:
                    	 break;
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
 
        int ans = 0;
        while (!stack.isEmpty()) {
        	System.out.println("-->" + stack.peek());
        	ans += stack.pop();
        }
        return ans;
    }

	public static void main(String[] args) {
		LC0227basicCalaulator3 test = new LC0227basicCalaulator3();
		String s = "1+2-8+9";
		int res = test.calculate(s);
		System.out.println("res:" + res);
	}
}
