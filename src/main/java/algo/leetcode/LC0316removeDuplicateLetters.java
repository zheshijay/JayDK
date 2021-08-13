package algo.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LC0316removeDuplicateLetters {
	 public String removeDuplicateLetters(String s) {
	      LinkedList<Character> deque = new LinkedList<>();
	      boolean[] seen = new boolean[26];
	      int[] count = new int[26];

	    // 把所有字符出现次数计算一遍
	      for (char c: s.toCharArray()) {
	          count[c - 'a']++;
	      }

	    // 遍历所有字符
	    for (char c: s.toCharArray()) {
	        if (!seen[c-'a']) {
	            // 1. 移除栈顶元素: 如果栈顶字母字典序小于当前字母 而且 栈顶字母在后面会继续出现
	            // 2. 如果栈是空的，就没必要判断直接入栈
	            while (!deque.isEmpty() && deque.getLast() > c && count[deque.getLast() - 'a'] > 0) {
	                seen[deque.getLast()-'a'] = false;
	                deque.removeLast();
	            }
	            deque.add(c);
	            seen[c-'a'] = true;
	        }
	        count[c-'a']--;
	    }

	    StringBuilder res = new StringBuilder();
	    for(char c : deque){
	        res.append(c);
	    }
	    return res.toString();
	}
	
	public static void main(String[] args) {
//		String s = "abca";
//		LC0316removeDuplicateLetters test = new LC0316removeDuplicateLetters();
//		String res = test.removeDuplicateLetters(s);
//		System.out.println(res);
		
		System.out.println(3%3);
		
	}
}
