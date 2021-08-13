package algo.roblox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniversityCareerFair {
	int maxEvents(int[] arrival, int[] duration) {
//		Arrays.sort(arrival);

		int len = arrival.length;
		int[][] intervals = new int[len][2];
		
		for (int i = 0; i< len; i++) {
			intervals[i][0] = arrival[i];
			intervals[i][1] = arrival[i] + duration[i];
		}
		
		Arrays.sort(intervals, (x,y)->(x[1]-y[1]));

//		Arrays.sort(arrival, (a, b) -> (a[1] - b[1]));
		int preFinish = intervals[0][1];
		int count = 1;
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] >= preFinish) {
//				System.out.println("a:" + arrival[i]);
				count++;
				preFinish = intervals[i][1];
			}
			
		}
		return count;
	}

	public static void main(String[] args) {
		UniversityCareerFair test = new UniversityCareerFair();
		
		int[] arrival1 = { 1, 3, 3, 5, 7 };
		int[] duration1 = { 2, 2, 1, 2, 1 };
		System.out.println(test.maxEvents(arrival1, duration1));
		int[] arrival2 = { 1, 3, 3, 5, 7, 6, 9 };
		int[] duration2 = { 2, 2, 1, 2, 1, 10, 2 };
		System.out.println(test.maxEvents(arrival2, duration2));
		int[] arrival = { 1, 3, 35, 7 };
		int[] duration = { 2, 2, 1, 2, 1 };
		System.out.println(test.maxEvents(arrival, duration));
	}
}
