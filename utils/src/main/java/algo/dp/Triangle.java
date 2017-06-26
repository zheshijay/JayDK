package algo.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 
 * 
 * 
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]

[
[2],
[3,4],
[6,5,7],
[4,1,8,3]
]


The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 */
public class Triangle {

	public int minimumTotal(List<List<Integer>> triangle) {
		int[] A = new int[triangle.size()+1];
		for(int i=triangle.size()-1;i>=0;i--){
			for(int j=0;j<triangle.get(i).size();j++){
				A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j);
			}
		}
		return A[0];
	}
	
	/*
	 * 
[
[2],
[3,4],
[6,5,7],
[4,1,8,3]
]
	 * 
	 */
	public int minimumTotal2(List<List<Integer>> triangle) {
		
		int size = triangle.size();
		int[][] dp = new int[size][size];
		//init dp, from bottom to top
		int index = 0;
		int row=0;
		for(List<Integer> eachList: triangle){
			int col=0;
			for(Integer eachNum: eachList){
				dp[row][col++] = eachNum;
			}
			row++;
		}

		System.out.println("dp: " + Arrays.deepToString(dp));

		for(int i = dp.length-1; i>0; i--){
			for(int j=0; j< dp[i-1].length-1; j++){
				dp[i-1][j] =Math.min(dp[i][j], dp[i][j+1])  +  dp[i-1][j];
			}		
		}
		return dp[0][0];
	}

	public static void main(String[] args){

		Triangle test = new Triangle();
		
		List<List<Integer>> triangle = new ArrayList<>();

		List<Integer> line1 = new ArrayList<Integer>();
		line1.add(2);

		List<Integer> line2 = new ArrayList<Integer>();
		line2.add(3);
		line2.add(4);


		List<Integer> line3 = new ArrayList<Integer>();
		line3.add(6);
		line3.add(5);
		line3.add(7);

		List<Integer> line4 = new ArrayList<Integer>();
		line4.add(4);
		line4.add(1);
		line4.add(8);
		line4.add(3);

		triangle.add(line1);
		triangle.add(line2);
		triangle.add(line3);
		triangle.add(line4);


		System.out.println("original: " + triangle);
		System.out.println("max sum is: " + test.minimumTotal2(triangle));

	}


}
