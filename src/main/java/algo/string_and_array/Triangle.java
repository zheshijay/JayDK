package algo.string_and_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 
 * 
 * 
LeetCode �C Triangle (Java)

Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note: Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 * 
 */
public class Triangle {
	public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		int[] total = new int[triangle.size()];
		int l = triangle.size() - 1;

		for (int i = 0; i < triangle.get(l).size(); i++) {
			total[i] = triangle.get(l).get(i);
		}

		// iterate from last second row
		for (int i = triangle.size() - 2; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i + 1).size() - 1; j++) {
				total[j] = triangle.get(i).get(j) + Math.min(total[j], total[j + 1]);
				System.out.println("total["+j+"] is " + total[j]);
			}
		}

		return total[0];
	}
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
		triangle.add(new ArrayList<>(Arrays.asList(2)));
		triangle.add(new ArrayList<>(Arrays.asList(3,4)));
		triangle.add(new ArrayList<>(Arrays.asList(6,5,7)));
		triangle.add(new ArrayList<>(Arrays.asList(4,1,8,3)));
		System.out.println("triangle:" + triangle);
		
		System.out.println("res:" + Triangle.minimumTotal(triangle));
		
	}

}
