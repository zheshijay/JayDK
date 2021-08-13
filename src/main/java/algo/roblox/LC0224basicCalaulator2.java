package algo.roblox;

import java.util.Deque;
import java.util.LinkedList;

public class LC0224basicCalaulator2 {

	public int calculate(String s) {
        Deque<Integer> ops = new LinkedList<Integer>();
        ops.push(1);
        int sign = 1;

        int ret = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
        	System.out.println("=========================> processing char:" + s.charAt(i));
        	
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
            	System.out.println("-- is num, do calculate --");
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                System.out.println("-- sign:" + sign);
                
                ret += sign * num;
                
                System.out.println("-- ret:" + ret);
            }
        }
        return ret;
    }

	public static void main(String[] args) {
		LC0224basicCalaulator2 test = new LC0224basicCalaulator2();
		String s = "1-(1+1-(2-3))-2";
		int res = test.calculate(s);
		System.out.println("res:" + res);
	}
}
