import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
	static class Interval{
		int start;
		int end;
		Interval(int start, int end){
			this.start=start;
			this.end=end;
		}
	}
	
	public int getCalendarDays( List<Interval> intervals){
		if(intervals == null || intervals.size()==0) return 0;
		Collections.sort(intervals, new Comparator<Interval>(){
			public int compare( Interval o1, Interval o2 ){
				return o1.start - o2.start;
			}
		});


		List<Interval> newIntervals = new ArrayList<>();


		Interval first = intervals.get(0);
		Interval pre = first;

		for(int i=1; i< intervals.size();i++){
			Interval cur = intervals.get(i);

			if(pre.end >= cur.start){
				int newStart = Math.min(pre.start, cur.start);
				int newEnd = Math.max(pre.end, cur.end);
				Interval newInterval = new Interval(newStart, newEnd);
				
				newIntervals.remove(pre);                            
				newIntervals.add(newInterval);
				pre = newInterval;

			}else{
				newIntervals.add(cur);
				pre = cur;;
			}
		}
		
		//newIntervals
		int count =0;
		for(Interval each: newIntervals){
			System.out.println("new interval: " +each.start + " - " + each.end);
			int days = each.end - each.start +1;
			count+=days;
		}

		return count;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		Interval i4 = new Interval(1,3);
		Interval i1 = new Interval(2,3);
		Interval i3 = new Interval(3,4);
		Interval i2 = new Interval(7,7);
		Interval i5 = new Interval(6,10);

		List<Interval> intervals = new ArrayList<>();

		intervals.add(i1);
		intervals.add(i2);
		intervals.add(i3);
		intervals.add(i4);
		intervals.add(i5);

		System.out.println(test.getCalendarDays(intervals));


	}
}
