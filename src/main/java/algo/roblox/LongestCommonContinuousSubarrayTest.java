package algo.roblox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestCommonContinuousSubarrayTest {

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
		List<String> res = null;
		int s1Len = s1.length;
		int s2Len = s2.length;
		
		int[][] dp = new int[s1Len+1][s2Len+1];
		int maxLen = 0;
		for(int i=1; i<=s1Len; i++) {
			for(int j=1; j<=s2Len; j++) {
				if (s1[i-1] == s2[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
					if (dp[i][j] > maxLen) {
						maxLen = dp[i][j];
						res = new ArrayList<>();

						// add the common elements
						for(int k=j-maxLen+1; k<=j; k++) {
							res.add(s2[k-1]);
						}

					}
				} else {
					// set to 0 means start a new comparison
					dp[i][j] = 0;
				}
				
				
			}
		}
		
		
		return res;
	}

	public static void main(String[] args) {
		String[] s1 = { "3234.html", "xys.html", "7hsaa.html" };
		String[] s2 = { "3234.html", "sdhsfjdsh.html", "xys.html", "7hsaa.html" };
		LongestCommonContinuousSubarrayTest longestCommonString = new LongestCommonContinuousSubarrayTest();
		List<String> list = longestCommonString.findLongestCommonString(s1, s2);
		
		
		System.out.println("------ res ------");
		for (String str : list) {
			System.out.println(str);
		}
	}

}
