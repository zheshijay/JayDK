package algo.roblox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LiftingWeightTest {

	
	// 用数组
	Integer ans = 0;
	public int getMaxWeight2(int[] weights, int maxCap) {
		dfs(weights, 0, 0, maxCap);
		return ans;
	}

	public void dfs(int[] weights, int start, int curW, int maxCap) {
		System.out.println("ans: " + ans + "|curW:" + curW);
		ans = Math.max(ans, curW);

		for (int i = start; i < weights.length; i++) {
			if (curW + curW + weights[i] <= maxCap) {
				dfs(weights, i + 1, curW + weights[i], maxCap);
			}
		}
	}

	public static void main(String[] args) {
		LiftingWeightTest test = new LiftingWeightTest();
		int[] weights = { 1, 3, 5 };
		int capacity = 7;

		System.out.println(test.getMaxWeight(weights, capacity));
		System.out.println(test.getMaxWeight2(weights, capacity));
	}
}
