package algo.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LC0424characterReplacement {
	public int[] sortedSquares(int[] A) {
        int n = A.length;
        int negative = -1;
        for (int i = 0; i < n; ++i) {
            if (A[i] < 0) {
                negative = i;
            } else {
                break;
            }
        }

        int[] ans = new int[n];
        int index = 0, i = negative, j = negative + 1;
        while (i >= 0 || j < n) {
            if (i < 0) {
                ans[index] = A[j] * A[j];
                ++j;
            } else if (j == n) {
                ans[index] = A[i] * A[i];
                --i;
            } else if (A[i] * A[i] < A[j] * A[j]) {
                ans[index] = A[i] * A[i];
                --i;
            } else {
                ans[index] = A[j] * A[j];
                ++j;
            }
            ++index;
        }

        return ans;
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
