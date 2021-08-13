package algo.dp;

public class Knappack {

//	1. Search
	int ans = 0, maxCap = 10;
	int[] w = new int[] { 1, 3, 5 };
	int[] v = new int[] { 2, 4, 9 };

	int getMaxValue1(int[] weight, int[] value, int w, int n) {
		this.w = weight;
		this.v = value;
		dfs(0, 0, 0);
		return ans;
	}

	void dfs(int startIndex, int curW, int curV) {
		ans = Math.max(ans, curV);

		for (int i = startIndex; i < w.length; i++) {
			if (curW + w[i] <= maxCap) {
				dfs(i + 1, curW + w[i], curV + v[i]);
			}
		}

	}

	int getMaxValue2(int n, int cap, int[] weight, int[] value) {
		int[][] dp = new int[n + 1][cap + 1];
		dp[0][0] = 0;
		for (int i = 1; i <= n; i++) { // 物品
			for (int j = 1; j <= cap; j++) { // 背包大小
				if (weight[i] > j) {
					// 当前物品i的重量比背包容量j大，装不下，那就采用上次的装包策略
					dp[i][j] = dp[i - 1][j];
					// System.out.print(table[i][j]+ " ");
				} else { // 装得下，Max{装物品i， 不装物品i}
					dp[i][j] = Math.max(dp[i - 1][j], value[i] + dp[i - 1][j - weight[i]]);
					// System.out.print(table[i][j]+ " ");
				}
			}
			// System.out.println();
		}
		return dp[n][cap];
	}

	public static void main(String[] args) {
		Knappack test = new Knappack();

		int n = 5, cap = 10; // 物品个数，背包容量
		int[] value = { 0, 6, 3, 5, 4, 6 }; // 各个物品的价值
		int[] weight = { 0, 2, 2, 6, 5, 4 }; // 各个物品的重量
		System.out.println(test.getMaxValue1(weight, value, cap, n));
		System.out.println(test.getMaxValue2(n, cap, weight, value));

	}
}
