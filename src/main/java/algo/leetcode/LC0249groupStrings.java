package algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC0249groupStrings {
	private static String hash(String str) {
		StringBuilder builder = new StringBuilder();
		for (int i = 1; i < str.length(); i++) {
			builder.append((str.charAt(i) - str.charAt(i - 1) + 26) % 26);
		}
		return builder.toString();
	}

	public static List<List<String>> groupStrings(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (String e : strs) {
			
			String hashed = hash(e);
			System.out.println("key:" + hashed + "|val:" + e);
			
			if (!map.containsKey(hashed)) {
				map.put(hashed, new ArrayList<String>());
			}
			List<String> list = map.get(hashed);
			list.add(e);
		}
		List<List<String>> res = new ArrayList<>();
		for (String key : map.keySet()) {
			res.add(map.get(key));
		}
		return res;
	}

	public static void main(String[] args) {
		String[] strings = new String[] { "abc", "cde", "acef", "xyz", "az", "ba", "a", "d", "r" };
		List<List<String>> res = LC0249groupStrings.groupStrings(strings);
		System.out.println(res);

	}
}
