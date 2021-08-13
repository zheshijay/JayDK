package algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LC0056mergeIntervals {
	/*
	 * Solution 1: 1 pointer
	 */
	public int[][] merge(int[][] intervals) {

		if (intervals.length == 0) {
			return new int[0][0];
		}
//		Arrays.sort(intervals, new Comparator<int[]>() {
//			public int compare(int[] interval1, int[] interval2) {
//				return interval1[0] - interval2[0];
//			}
//		});
		
		Arrays.sort(intervals, (x,y)->{return x[0]-y[0];});

		System.out.println("intervals:" + Arrays.deepToString(intervals));
		
		List<int[]> merged = new ArrayList<int[]>();
		for (int i = 0; i < intervals.length; ++i) {
			
			int l = intervals[i][0], r = intervals[i][1];
			
			if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < l) {
				merged.add(new int[] { l, r });
			} else {
				merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], r);
			}
			
			System.out.println("merged:" + Arrays.deepToString(merged.toArray()));
			
		}
		
		
		return merged.toArray(new int[merged.size()][]);
		
	}

	// practice
	public int[][] merge2(int[][] intervals) {
		Arrays.sort(intervals, (x,y)->{return x[0]-y[0];});
		List<int[]> merged = new ArrayList<>();

		for(int[] interval: intervals) {
			int curStart = interval[0], curEnd = interval[1];
			if (merged.size() == 0 || curStart > merged.get(merged.size()-1)[1]) {
				merged.add(new int[] {curStart, curEnd});
			} else {
				merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size()-1)[1], curEnd);
			}
		}

		return merged.toArray(new int[merged.size()][]);
	}

	// Driver code
	public static void main(String args[]) {
//		int[][] tt = new int[0][2];
//		List<int[]> merged = new ArrayList<int[]>();
//		merged.add(new int[] {1,2});
//		merged.add(new int[] {3,4});
//		System.out.println(merged);

		LC0056mergeIntervals test = new LC0056mergeIntervals();
		int[][] intervals = {{1,3}, {2,6}, {8,10}, {15,18}};
		int[][] res = test.merge2(intervals);
		System.out.println("res:" + Arrays.deepToString(res));
	}
}
