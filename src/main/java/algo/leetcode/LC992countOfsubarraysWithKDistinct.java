package algo.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LC992countOfsubarraysWithKDistinct {
	public int subarraysWithKDistinct(int[] A, int K) {
		Window window1 = new Window();
		Window window2 = new Window();
		int ans = 0, left1 = 0, left2 = 0;

		for (int right = 0; right < A.length; ++right) {
			int x = A[right];
			window1.add(x);
			window2.add(x);

			while (window1.different() > K)
				window1.remove(A[left1++]);
			
			while (window2.different() >= K)
				window2.remove(A[left2++]);

			ans += left2 - left1;
		}

		return ans;
	}
}

class Window {
	Map<Integer, Integer> count;
	int nonzero;

	Window() {
		count = new HashMap<>();
		nonzero = 0;
	}

	void add(int x) {
		count.put(x, count.getOrDefault(x, 0) + 1);
		if (count.get(x) == 1)
			nonzero++;
	}

	void remove(int x) {
		count.put(x, count.get(x) - 1);
		if (count.get(x) == 0)
			nonzero--;
	}

	int different() {
		return nonzero;
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
