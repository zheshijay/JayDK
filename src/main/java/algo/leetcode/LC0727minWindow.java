package algo.leetcode;

public class LC0727minWindow {

	public static final String EMPTY = "";

	public String minWindow(String S, String T) {
		if (S == null || T == null || S.length() == 0 || T.length() == 0)
			return EMPTY;
		int n = S.length(), m = T.length(); // S的长度是n，T的长度是m

		int i = 0, j = 0; // i 是 s 的索引，j 是 t 的索引
		int left = 0, right = 0; // 窗口的两端
		int minLen = Integer.MAX_VALUE;
		String res = "";

		while (i < n) {
			// 正向匹配，找到T中最后一个字符
			while (i < n && j < m) {
				if (S.charAt(i) == T.charAt(j)) {
					i++;
					j++;
				} else
					i++;
			}
			// 当前起点之后再匹配不到 T 了
			if (j < m)
				break;

			// 逆向缩窗，找到T的第一个字符后结束
			right = i - 1;
			left = i - 1;
			j = m - 1;
			while (left >= 0 && j >= 0) {
				if (S.charAt(left) == T.charAt(j)) {
					left--;
					j--;
				} else
					left--;
			}
			left++;

			// 更新窗口长度
			if (right - left + 1 < minLen) {
				minLen = right - left + 1;
				res = S.substring(left, left + minLen);
			}

			// 下一个可能的窗口起点
			i = left + 1;
			j = 0;
		}
		return res;
	}
	
//	   String minWindow(String S, String T) {
//	        int m = S.size(), n = T.size(), start = -1, minLen = INT_MAX, i = 0, j = 0;
//	        while (i < m) {
//	            if (S[i] == T[j]) {
//	                if (++j == n) {
//	                    int end = i + 1;
//	                    while (--j >= 0) {
//	                        while (S[i--] != T[j]);
//	                    }
//	                    ++i; ++j;
//	                    if (end - i < minLen) {
//	                        minLen = end - i;
//	                        start = i;
//	                    }
//	                }
//	            }
//	            ++i;
//	        }
//	        return (start != -1) ? S.substr(start, minLen) : "";
//	    }

	public static void main(String[] args) {
		LC0727minWindow test = new LC0727minWindow();
		String S = "abcdebdde";
		String T = "bde";

		String res = test.minWindow(S, T);
		System.out.println("res:" + res);

	}
}
