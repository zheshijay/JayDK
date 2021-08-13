package algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC0057insertIntervals {
	/*
	 * Solution 1: 1 pointer
	 */
	public int[][] insert(int[][] intervals, int[] newInterval) {
		int left = newInterval[0];
		int right = newInterval[1];
		boolean placed = false;
		List<int[]> merged = new ArrayList<int[]>();

		for (int[] interval : intervals) {
			if (interval[0] > right) {
				// 在插入区间的右侧且无交集
				if (!placed) {
					merged.add(new int[] { left, right });
					placed = true;
				}
				merged.add(interval);
			} else if (interval[1] < left) {
				// 在插入区间的左侧且无交集
				merged.add(interval);
			} else {
				// 与插入区间有交集，计算它们的并集
				left = Math.min(left, interval[0]);
				right = Math.max(right, interval[1]);
			}
			
			System.out.println("merged:" + Arrays.deepToString(merged.toArray()));
			
		}

		if (!placed) {
			merged.add(new int[] { left, right });
		}

		int[][] ans = new int[merged.size()][2];

		for (int i = 0; i < merged.size(); ++i) {
			ans[i] = merged.get(i);
		}
		return ans;
	}

	// Driver code
	public static void main(String args[]) {
		LC0057insertIntervals test = new LC0057insertIntervals();
		int[][] intervals = { { 1, 3 }, { 6, 9 } };
		int[] newInterval = { 2, 5 };
		
		int [][] res = test.insert(intervals, newInterval);
		System.out.println("res:" + Arrays.deepToString(res));
	}
}
