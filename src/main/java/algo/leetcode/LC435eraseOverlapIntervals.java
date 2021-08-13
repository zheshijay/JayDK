package algo.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LC435eraseOverlapIntervals {
	 public int eraseOverlapIntervals(int[][] intervals) {
	        Arrays.sort(intervals, new Comparator<int[]>() {
	            @Override
	            public int compare(int[] o1, int[] o2) {
	                if (o1[0] != o2[0]) {
	                    return o1[0] - o2[0];
	                }else
	                    return o1[1] - o2[1];
	            }
	        });
	        int count = 0;
	        int i = 0,j=1;  //i指向待比较的左边区间，j指向待比较的右边区间
	        for (i = 0; i < intervals.length-1 && j<=intervals.length-1; i++,j++) {
	            if (intervals[i][1] > intervals[j][0]) {
	                i = intervals[i][1] < intervals[j][1] ? i - 1 : j - 1;
	                count++;
	            } else {
	                i = j-1;
	            }
	        }
	        return count;
	    }
	
	// Driver code
	public static void main(String args[]) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int k = 3;
//		printKMax(arr, arr.length, k);
		printMax(arr, arr.length, k);
	}
}
