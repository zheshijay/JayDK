package algo.string_and_array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

	/*
	 * 
LeetCode �C Merge Intervals

Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].

Analysis

The key to solve this problem is defining a Comparator first to sort the arraylist of Intevals.
	 */

	static class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}

	private class IntervalComparator implements Comparator<Interval> {
		public int compare(Interval a, Interval b) {
			return a.start - b.start;
		}
	}

	public static void print(List<Interval> res){

		for(Interval i: res){
			System.out.print("[ " + i.start +  ", " + i.end + "]" );
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
		for(int i=1; i<intervals.size(); i++){
			
			Interval cur = intervals.get(i);
			if(pre.end >=cur.start) {  //overlap
				Interval newInterval = new Interval(pre.start, Math.max(pre.end, cur.end) );
				res.add(newInterval);
				pre = newInterval;
			}else{
				res.add(cur);
				pre = cur;
			}
			
		}
		
		return res;
		
	}


	public static void main(String[] args){
		//		Given [1,3],[2,6],[8,10],[15,18],
		//		return [1,6],[8,10],[15,18].

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
