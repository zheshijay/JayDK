package algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC0256paintHouse {
	  public int minCost(int[][] costs) {
		  
		  int len = costs.length;
		  
		// dp含义第i个房子分别涂0：红色，1：蓝色，2：绿色的总花费最小值
		  int[][] dp = new int[len][3];
		  
		  // init dp
		  dp[0][0] = costs[0][0];
		  dp[0][1] = costs[0][1];
		  dp[0][2] = costs[0][2];
		  
		  for(int i=1; i<len; i++) {
			  // 3 colors
			  dp[i][0] = costs[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
			  dp[i][1] = costs[i][1] + Math.min(dp[i-1][2], dp[i-1][0]);
			  dp[i][2] = costs[i][2] + Math.min(dp[i-1][1], dp[i-1][0]);
		  }
		  
		  return Math.min(dp[len - 1][0], Math.min(dp[len - 1][1], dp[len - 1][2]));
		  
	  }
}
