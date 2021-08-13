package algo.string_and_array;

import algo.utils.PrintUtils;

public class NumberofIslands {



	public int findNumOfIsLand(int[][] grid) {

		int cnt=0;

		for(int x=0; x<grid.length; x++) {
			for(int y=0; y<grid[0].length; y++) {

				if(grid[x][y] ==1) {


					//mark visited place
					myDFS(grid, x, y);
					cnt++;

					System.out.println("-----------------------------");

					PrintUtils.printTwoDArray(grid);
				}
			}


		}

		return cnt;
	}



	public void myDFS(int[][] a, int x, int y) {

		System.out.println("x="+x + " y="+y);
		
		if(x <0 || y<0 || x > a.length-1 || y >a[0].length-1 || a[x][y] ==0) return;

		a[x][y] = 0;

		myDFS(a, x+1, y);
		myDFS(a, x-1, y);
		myDFS(a, x, y+1);
		myDFS(a, x, y-1);

	}


	public static void main(String[] args){

		NumberofIslands test = new NumberofIslands();

		int[][] mat = new int[][]{
			{1, 1, 0, 1, 0},
			{1, 0, 0, 1, 0},
			{0, 0, 1, 0, 0},
			{1, 0, 0, 1, 1}}
		;
		
		
		System.out.println("Num of island is:" + test.findNumOfIsLand(mat));

	}
}
