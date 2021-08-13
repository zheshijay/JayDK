package algo.leetcode;

import java.util.LinkedList;

public class LC0394decodeString {
	public static String decodeString(String s) {

		StringBuilder res = new StringBuilder();
		int multi = 0;

		LinkedList<Integer> stack_multi = new LinkedList<>();
		LinkedList<String> stack_res = new LinkedList<>();

		for (Character c : s.toCharArray()) {

			if (c == '[') {
				stack_multi.addLast(multi);
				stack_res.addLast(res.toString());
				multi = 0;
				res = new StringBuilder();

			} else if (c == ']') {
				StringBuilder tmp = new StringBuilder();
				int cur_multi = stack_multi.removeLast();
				for (int i = 0; i < cur_multi; i++)
					tmp.append(res);
				res = new StringBuilder(stack_res.removeLast() + tmp);
			} else if (c >= '0' && c <= '9') {
				System.out.println("multi1 is:" + multi);
				multi = multi * 10 + Integer.parseInt(c + "");
				System.out.println("multi2 is:" + multi);
			} else
				res.append(c);
		}
		return res.toString();
	}

	public static void main(String[] args) {
		String str = "12[a]2[bc]";

		String decode = LC0394decodeString.decodeString(str);
		System.out.println("" + decode);

	}
}
