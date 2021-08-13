package algo.string_and_array;

import java.util.Arrays;

/*
给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。

如果剩余字符少于 k 个，则将剩余字符全部反转。
如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 

示例:

输入: s = "abcdefg", k = 2
输出: "bacdfeg"

 */
public class ReverseStringEveryGivenK {

	/*
	 * Reverse every K diff
	 * 
	 * Input: [a, b, c, d, e, f, g] Output: [b, a, d, c, f, e, g]
	 * 
	 * 
	 */
	public String reverseStr(String s, int k) {
		char[] a = s.toCharArray();
		for (int start = 0; start < a.length; start += 2 * k) {
			int i = start, j = Math.min(start + k - 1, a.length - 1);
			while (i < j) {
				char tmp = a[i];
				a[i++] = a[j];
				a[j--] = tmp;
			}
		}
		return new String(a);
	}

// 2 pointers
	public String reverseStr2(String s, int k) {
		char[] ch = s.toCharArray();
		int n = ch.length;
		// 每2k个元素为一组进行反转
		for (int i = 0; i < n; i += 2 * k) {
			int left = i;
			int right = (i + k - 1 < n) ? i + k - 1 : n - 1; // 判断下标是否越界
			while (left <= right) {
				char temp = ch[left];
				ch[left] = ch[right];
				ch[right] = temp;
				left++;
				right--;
			}
		}
		String str = new String(ch);
		return str;

	}

	public static void main(String args[]) {
		ReverseStringEveryGivenK test = new ReverseStringEveryGivenK();

		String str = "abcdefg";
		String reversed = test.reverseStr(str, 2);

		System.out.println("reversed: " + reversed);

	}
}
