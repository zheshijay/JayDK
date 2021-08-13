package algo.roblox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import algo.string_and_array.LongestCommonPrefix;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		int len = strs.length;

		String lcp = strs[0];
		for (int i = 1; i < len; i++) {
			lcp = getLCP(lcp, strs[i]);
		}
		return lcp;
	}

	private String getLCP(String s1, String s2) {
		int index1 = 0, index2 = 0;
		int lcpLen = 0;
		while (index1 < s1.length() && index2 < s2.length() && s1.charAt(index1) == s2.charAt(index2)) {
			lcpLen++;
			index1++;
			index2++;
		}
		
		return s1.substring(0, lcpLen);
	}

	public static void main(String args[]) {
		LongestCommonPrefix test = new LongestCommonPrefix();
		String[] strs = new String[] { "geeksforgeeks", "geeks", "geek", "geezer" };
		System.out.println(test.longestCommonPrefix(strs));
	}
}
