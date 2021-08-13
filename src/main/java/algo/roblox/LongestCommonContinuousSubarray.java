package algo.roblox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestCommonContinuousSubarray {

	/*
	 *
2. Longest Common Continuous Subarray
输入：

[
  ["3234.html", "xys.html", "7hsaa.html"], // user1
  ["3234.html", "sdhsfjdsh.html", "xys.html", "7hsaa.html"] // user2
]
输出两个user的最长连续且相同的访问记录。


["xys.html", "7hsaa.html"]
/**
和LCS做法类似，如果当前两个string相等就把当前格子变成[i - 1][j - 1] + 1。不相等就保留0。
*/


	List<String> findLongestCommonString(String[] s1, String[] s2) {
		int n = s1.length;
		int m = s2.length;
		int[][] dp = new int[n + 1][m + 1];
		int maxLen = 0;
		List<String> result = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				
				System.out.println("Compare " + s1[i-1] + " and " + s2[j-1]);
				if (s1[i - 1].equals(s2[j - 1])) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					
					System.out.println("==> dp[i][j]: " + dp[i][j] + " and maxLen:" + maxLen );
					if (dp[i][j] > maxLen) {
						maxLen = dp[i][j];
						result = new ArrayList<>();
						
						for (int k = j; k > j - maxLen; k--) {
							result.add(0, s2[k - 1]);
						}

						System.out.println("---------> |result:" + result);
					}
					
				} else {
					dp[i][j] = 0;
				}
			}
		}
		
		System.out.println("dp:" + Arrays.deepToString(dp));
		return result;
	}
	
	
	
	List<String> findLongestCommonStringTest(String[] s1, String[] s2) {
		int len1 = s1.length, len2 = s2.length;
		int[][] dp = new int[len1+1][len2+1];
		dp[0][0] = 0;

		int maxLen = 0;
		List<String> res = new ArrayList<>();
		
		for(int i=1; i <= len1; i++) {
			for(int j=1; j <= len2; j++) {
				if (s1[i-1].equals(s2[j-1])) {
					dp[i][j] = dp[i-1][j-1] + 1;
					
					if (maxLen < dp[i][j]) {
						maxLen = dp[i][j];
						
						res = new ArrayList<>();
//						for (int k = j - maxLen; k <= j; k++) {
//							res.add(s2[k]);
//						}
						for (int k = j; k > j - maxLen; k--) {
							res.add(0, s2[k - 1]);
						}
						
					}
					
				} else {
					dp[i][j] = 0;
				}
			}
		}
		
		return res;
		
		
	}

	public static void main(String[] args) {
		String[] s1 = { "3234.html", "xys.html", "7hsaa.html" };
		String[] s2 = { "3234.html", "sdhsfjdsh.html", "xys.html", "7hsaa.html" };
		LongestCommonContinuousSubarray longestCommonString = new LongestCommonContinuousSubarray();
		List<String> list1 = longestCommonString.findLongestCommonString(s1, s2);
		List<String> list2 = longestCommonString.findLongestCommonStringTest(s1, s2);
		
		System.out.println("s1:" + Arrays.toString(s1));
		System.out.println("s2:" + Arrays.toString(s2));
		System.out.println("------ res ------");
		System.out.println("list1:" + list1);
		System.out.println("list2:" + list2);
	}

}
