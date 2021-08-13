package algo.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class LC0388lengthLongestPath {
	public int lengthLongestPath(String input) {
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		int ans = 0;
		
		System.out.println("str before split:" + input);
		
		// 以 \n 分割成字符串数组
		String[] str = input.split("\n");
		
		System.out.println("str:" + Arrays.toString(str));
		
		// dir,\tsubdir1,\tsubdir2,\tfile.ext
		for (String s : str) {
			// level 代表当前字符串的首字母索引
			// 字符串前面可能会有多个 \t,故使用 lastIndexOf 找出最后一个 \t 位置即可
			
			System.out.println(" ---> s:" + s);
			int level = s.lastIndexOf("\t") + 1;
			System.out.println(" ---> level:" + level);
			
			System.out.println("stack 0:" + stack);
			while (level + 1 < stack.size()) {
				System.out.println("stack 1:" + stack);
				stack.pop();
				System.out.println("stack 2:" + stack);
			}
			// 之前入栈的字符串 + 当前遍历到的字符串的长度
			int len = stack.peek() + (s.length() - level + 1);
			System.out.println("len:" + len);
			stack.push(len);
			if (s.contains(".")) {
				ans = Math.max(ans, len - 1);
			}
		}
		return ans;
	}
	
	
	public static void main(String[] args) {
		String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
		
		LC0388lengthLongestPath test = new LC0388lengthLongestPath();
		int res = test.lengthLongestPath(input);
		
		System.out.println("res:" + res);
	}
	
	
}
