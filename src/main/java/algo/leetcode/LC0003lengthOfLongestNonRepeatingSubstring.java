package algo.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC0003lengthOfLongestNonRepeatingSubstring {


	/*
	 * Sliding window
	 */
	public int lengthOfLongestSubstring2(String s) {
		int n = s.length(), ans = 0;
		Map<Character, Integer> map = new HashMap<>();

		for (int end = 0, start = 0; end < n; end++) {
			char alpha = s.charAt(end);
			if (map.containsKey(alpha)) {

				start = Math.max(map.get(alpha) + 1, start);
				System.out.println("Contains " + alpha + "--Update start to:" + start);
			}

			System.out.println("start:" + start + "|end:" + end);

			ans = Math.max(ans, end - start + 1);
			map.put(alpha, end);
		}
		return ans;
	}

	public int lengthOfLongestSubstringTemp(String s) {
		Map<Character, Integer> seen = new HashMap<>();
		int res = -1;
		int left = 0;
		for (int right = 0; right < s.length(); right++) {
			if (seen.containsKey(s.charAt(right))) {
				// 用map seen来保存窗口的值
				// 注意是先计算res然后才覆盖重复位置的下标
				// 两种情况
				// 1. 当前char在窗口中 (abcdafg) 解释：a在复合条件窗口abcd里面， left移动到第一个b的位置)
				// 2. 不在有效字段中 (abcdbca) 第二个a不在符合条件窗口b里面，因为b出现的时候left已经移动到第一个a后面了，
				// 之后a再出现的话就不可以再用第一个a的下标了，因为这时用seen.get(s.charAt(right)) + 1就会取到第一个a后面))
			
				
				left = Math.max(left, seen.get(s.charAt(right)) + 1);
				
//				left = seen.get(s.charAt(right)) + 1;
			}

			res = Math.max(res, right - left + 1);
			seen.put(s.charAt(right), right);
//			System.out.println(res);
		}
		return res;
	}

	public static void main(String[] args) {
		LC0003lengthOfLongestNonRepeatingSubstring test = new LC0003lengthOfLongestNonRepeatingSubstring();

		String str = "abcb";
//		String str = "abcabcbb";
//		String str = "bbbbb";
//		String str = "pwwkew";
//		String str = "abcaxnabcabb";
//		String str = "abbaxyz";
//		String str = "abbbbba";
		int res = test.lengthOfLongestSubstringTemp(str);
		System.out.println(res);

	}

}
