package algo.string_and_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

	/*
	 * 
	 * 给出一个区间的集合，请合并所有重叠的区间。
	 * 
	 * 示例 1: 输入: intervals = [[1,3],[2,6],[8,10],[15,18]] 输出: [[1,6],[8,10],[15,18]]
	 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
	 * 
	 * 示例 2: 输入: intervals = [[1,4],[4,5]] 输出: [[1,5]] 解释: 区间 [1,4] 和 [4,5]
	 * 可被视为重叠区间。
	 * 
	 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/merge-intervals
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	private class IntervalComparator implements Comparator<Interval> {
		public int compare(Interval a, Interval b) {
			return a.start - b.start;
		}
	}

	public static void print(List<Interval> res) {

		for (Interval i : res) {
			System.out.print("[ " + i.start + ", " + i.end + "]");
		}
		System.out.println();
	}

	public ArrayList<Interval> myMerge(ArrayList<Interval> intervals) {

		Collections.sort(intervals, new Comparator<Interval>() {

			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start - o2.start;
			}
		});

		ArrayList<Interval> res = new ArrayList<Interval>();

		Interval pre = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {

			Interval cur = intervals.get(i);
			if (pre.end >= cur.start) { // overlap
				Interval newInterval = new Interval(pre.start, Math.max(pre.end, cur.end));
				res.add(newInterval);
				pre = newInterval;
			} else {
				res.add(cur);
				pre = cur;
			}

		}

		return res;
	}

	public int[][] merge2(int[][] intervals) {
		if (intervals.length == 0) {
			return new int[0][2];
		}
		Arrays.sort(intervals, new Comparator<int[]>() {
			public int compare(int[] interval1, int[] interval2) {
				return interval1[0] - interval2[0];
			}
		});
		List<int[]> merged = new ArrayList<int[]>();
		for (int i = 0; i < intervals.length; ++i) {
			int L = intervals[i][0], R = intervals[i][1];
			if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
				merged.add(new int[] { L, R });
			} else {
				merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
			}
		}
		return merged.toArray(new int[merged.size()][]);
	}

	public static void main(String[] args) {
		// Given [1,3],[2,6],[8,10],[15,18],
		// return [1,6],[8,10],[15,18].

		MergeIntervals test = new MergeIntervals();
		Interval i1 = new Interval(1, 3);
		Interval i2 = new Interval(2, 6);
		Interval i3 = new Interval(8, 10);
		Interval i4 = new Interval(15, 18);

		ArrayList<Interval> intervals = new ArrayList();

		intervals.add(i2);
		intervals.add(i3);
		intervals.add(i4);
		intervals.add(i1);

		ArrayList<Interval> res = test.myMerge(intervals);

		System.out.println(" --- result ");
		print(res);

	}

}
