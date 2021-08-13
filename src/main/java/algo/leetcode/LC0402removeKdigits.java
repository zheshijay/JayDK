package algo.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LC0402removeKdigits {

	 public String removeKdigits(String num, int k) {
	        Deque<Character> deque = new LinkedList<Character>();
	        int length = num.length();
	        for (int i = 0; i < length; ++i) {
	            char digit = num.charAt(i);
	            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
	                deque.pollLast();
	                k--;
	            }
	            deque.offerLast(digit);
	            System.out.println("deque1:" + deque);
	        }
	        
	       

	        for (int i = 0; i < k; ++i) {
	            deque.pollLast();
	            System.out.println("deque2:" + deque);
	        }
	        System.out.println("deque3:" + deque);
	  
	        // remove leading ZEROs and save the res
	        StringBuilder ret = new StringBuilder();
	        boolean leadingZero = true;
	        while (!deque.isEmpty()) {
	            char digit = deque.pollFirst();
	            if (leadingZero && digit == '0') {
	                continue;
	            }
	            leadingZero = false;
	            ret.append(digit);
	        }
	        return ret.length() == 0 ? "0" : ret.toString();
	    }
	 
	 public static void main(String[] args) {
		 LC0402removeKdigits test = new LC0402removeKdigits();
		 
		 // test case 01
		 String num = "1432219";
		 int k = 3;
		 
//		 String num = "12345";
//		 int k = 3;

		 // test case 02
//		String num = "9";
//		int k = 1;
		
		String res = test.removeKdigits(num, k);
		System.out.println(res);
		
		
	}
	
}
