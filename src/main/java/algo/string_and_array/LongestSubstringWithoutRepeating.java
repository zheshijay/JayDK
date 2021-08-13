package algo.string_and_array;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating {

	/*
	 * 
	 * 
	 * LeetCode �C Longest Substring Without Repeating Characters (Java)
	 * 
	 * Given a string, find the length of the longest substring without repeating
	 * characters.
	 * 
	 * For example, the longest substring without repeating letters for "abcabcbb"
	 * is "abc", which the length is 3.
	 * 
	 * For "bbbbb" the longest substring is "b", with the length of 1.
	 * 
	 */
	public int lengthOfLongestSubstring(String s) {
		HashSet<Character> set = new HashSet<>();
		int longest = 0;
		int count = 0;

		for (int i = 0; i < s.length(); i++) {
			System.out.println("----------processing:" + s.charAt(i));

			int j = i;
			while (j < s.length() && !set.contains(s.charAt(j))) {
				System.out.println("adding:" + s.charAt(j) + " ---- j is:" + j);
				set.add(s.charAt(j));
				count++;
				j++;
			}

//			set.add(c);
			longest = Math.max(count, longest);
			set.clear();
			count = 0;
		}
		return longest;
	}

	/*
	 * aaab aab abcab
	 */
	public int lengthOfLongestSubstring2(String s) {
		// 哈希集合，记录每个字符是否出现过
		Set<Character> occ = new HashSet<Character>();
		int n = s.length();
		// 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
		int rk = -1, ans = 0;
		for (int i = 0; i < n; ++i) {
			if (i != 0) {
				// 左指针向右移动一格，移除一个字符
				occ.remove(s.charAt(i - 1));
			}
			while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
				// 不断地移动右指针
				occ.add(s.charAt(rk + 1));
				++rk;
			}

			System.out.println(occ);

			// 第 i 到 rk 个字符是一个极长的无重复字符子串
			ans = Math.max(ans, rk - i + 1);
		}
		return ans;
	}

	public static void main(String args[]) {
		LongestSubstringWithoutRepeating test = new LongestSubstringWithoutRepeating();

//		System.out.println(test.lengthOfLongestSubstring2("abcdb"));
		System.out.println(test.lengthOfLongestSubstring("pwwkew"));
	}
}
