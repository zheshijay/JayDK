package algo.string_and_array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*


 */
public class InsertInterval {
	static class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public static void print(List<Interval> inters){

		for(Interval i: inters){
			System.out.print("[ " + i.start +  ", " + i.end + "]" );
		}
	}
	
	public static List<Interval> insertInterval(List<Interval>inters, Interval targetInterval){
		inters.add(targetInterval);
		
		//sort the intervals by start value
		Collections.sort(inters, new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
		});
		
		print(inters);
		
		List<Interval> res = new ArrayList<Interval>();
		
		Interval firstInterval = inters.get(0);
		Interval previous = firstInterval;
		
		for(int i=1; i< inters.size(); i++){
			Interval curInterval = inters.get(i);
			
			if(previous.end >= curInterval.start){
				int start = Math.min(previous.start, curInterval.start);
				int end = Math.max(previous.end, curInterval.end);
				
				System.out.println(" new start " + start + " end:" + end);
				
				Interval newIntval = new Interval(start, end);
				res.add(newIntval);
				previous = newIntval;
				
			}else{
				res.add(curInterval);
				previous = curInterval;
			}
		}
		return res;
		
	}
	
	
	public static void main(String[] args){
//		Example 1:
//			Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
		
//			Example 2:
//			Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
//			This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

		InsertInterval test = new InsertInterval();
		Interval i1 = new Interval(1, 3);
		Interval i2 = new Interval(2, 6);
//		Interval i3 = new Interval(8, 10);
//		Interval i4 = new Interval(15, 18);


		ArrayList<Interval> intervals = new ArrayList();
		
		intervals.add(i1);
		intervals.add(i2);
//		intervals.add(i3);
//		intervals.add(i4);

		
		Interval newInterval = new Interval(2,5);


		List<Interval> res = test.insertInterval(intervals, newInterval);

		
		test.print(res);
	}

}
