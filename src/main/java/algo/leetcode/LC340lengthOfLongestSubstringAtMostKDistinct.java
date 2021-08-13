package algo.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LC340lengthOfLongestSubstringAtMostKDistinct {

	/*
	 * Sliding window
	 */
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		int n = s.length();
		if (n * k == 0)
			return 0;

		// sliding window left and right pointers
		int left = 0;
		int right = 0;
		// hashmap character -> its rightmost position
		// in the sliding window
		HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();

		int max_len = 1;

		while (right < n) {
			// add new character and move right pointer
			hashmap.put(s.charAt(right), right++);

			// slidewindow contains 3 characters
			if (hashmap.size() == k + 1) {
				// delete the leftmost character
				int del_idx = Collections.min(hashmap.values());
				hashmap.remove(s.charAt(del_idx));
				// move left pointer of the slidewindow
				left = del_idx + 1;
			}

			max_len = Math.max(max_len, right - left);
		}
		return max_len;
	}

	public static void main(String[] args) {
//		LC395MaximumSumAtLeastKRepeatedNumbers test = new LC395MaximumSumAtLeastKRepeatedNumbers();
////		String s = "ababbc";
//		String s = "leeetcode";
//		int k = 2;
//
//		int res = test.longestSubstring2(s, k);
//		System.out.println("res:" + res);

		Map<String, String> m = new HashMap<>();

		m.put("a", "300");
		m.put("b", "200");
		m.put("c", "100");

		System.out.println("map:" + m);

		String min = Collections.min(m.values());
		String max = Collections.max(m.values());
		System.out.println("min:" + min);
		System.out.println("max:" + max);

	}

}
