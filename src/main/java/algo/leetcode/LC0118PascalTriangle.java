package algo.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LC0118PascalTriangle {
	 public List<List<Integer>> generate(int numRows) {
	        List<List<Integer>> ret = new ArrayList<List<Integer>>();
	        for (int i = 0; i < numRows; ++i) {
	            List<Integer> row = new ArrayList<Integer>();
	            for (int j = 0; j <= i; ++j) {
	                if (j == 0 || j == i) {
	                    row.add(1);
	                } else {
	                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
	                }
	            }
	            ret.add(row);
	        }
	        return ret;
	    }
}
