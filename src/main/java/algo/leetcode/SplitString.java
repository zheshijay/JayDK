package algo.leetcode;

/*
 * 
给一个字符类型的数组chas和一个整数size，请把大小为size的左半区整体右移到右半区，右半区整体移动到左边。
示例1
输入
"abcdefg",3
输出
"defgabc"
 */

public class SplitString {

	public static String reverse(int left, int right, String str) {
		int len = str.length();
		// 把字符串转换成数组
		char[] arr = str.toCharArray();
		while (left < right) {
			char tmp = arr[left];
			arr[left] = arr[right];
			arr[right] = tmp;
			left++;
			right--;
		}
		// 把arr数组转换成字符串
		return String.valueOf(arr);
	}

	public static String reversekString (String str, int k) {
		int len = str.length();
		if (str == null || k <= 0 || k > len) {
			return null;
		}
		str = reverse(0, k - 1, str);
		str = reverse(k, len - 1, str);
		str = reverse(0, len - 1, str);
		return str;
	}

	// 往右移动size
	public String reverseStringII(String str, int size) {
		if (size > str.length()) { return null; }
		String s1 = str.substring(0, size);
		String s2 = str.substring(size, str.length());
		return s2 + s1;
		
	}

	public static void main(String[] args) {
		SplitString test = new SplitString();
		String str = "abcdefg";
		String res = test.reverseStringII(str, 1);
		String res2 = test.reversekString(str, 1);
		System.out.println("res:" + res);
		System.out.println("ans:" + res2);
	}

}
