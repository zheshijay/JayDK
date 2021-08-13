package algo.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class LC0200numIslands {

	static final int[][] DIRS = new int[][] {{0, 1},{0, -1}, {1, 0}, {-1, 0}};

	public int numIslands(char[][] grid) {
		int len = grid.length;
		int wid = grid[0].length;
		int count = 0;

		for (int x = 0; x < len; x++) {
			for (int y = 0; y < wid; y++) {
				
				if (grid[x][y] == '1') {
//					bfs(grid, x, y);
					dfs(grid, x, y);
					count++;
				}
			}
		}
		return count;
	}


	 private void bfs(char[][] grid, int startX, int startY){
		 int len = grid.length, wid = grid[0].length;
	        Deque<int[]> queue = new LinkedList<>();
	        queue.add(new int[] { startX, startY });
	        while(!queue.isEmpty()){
	            int[] cur = queue.poll();
	            int x = cur[0], y = cur[1];
	            System.out.println("x:" + x + "|y:" + y);
	            grid[x][y] = '0';
	            for(int[] dir: DIRS) {
	            	int nx = x + dir[0], ny = y + dir[1];
	            	if (nx >=0 && nx < len && ny >=0 && ny < wid && grid[nx][ny] == '1') {
	            		  queue.push(new int[] { nx, ny });
	            		}
	            	}
	        	}
	        }
	 
	 private void dfs(char[][] grid, int startX, int startY){
		 int len = grid.length, wid = grid[0].length;
		 Stack<int[]> queue = new Stack<>();
	        queue.add(new int[] { startX, startY });
	        while(!queue.isEmpty()){
	            int[] cur = queue.pop();
	            int x = cur[0], y = cur[1];
	            
	            System.out.println("x:" + x + "|y:" + y);
	            
	            grid[x][y] = '0';
	            for(int[] dir: DIRS) {
	            	int nx = x + dir[0], ny = y + dir[1];
	            	if (nx >=0 && nx < len && ny >=0 && ny < wid && grid[nx][ny] == '1') {
	            		  queue.push(new int[] { nx, ny });
	            		}
	            	}
	        	}
	        }

	public static void main(String[] args) {
		LC0200numIslands test = new LC0200numIslands();
//		char[][] grid = new char[][] { 
//			{ '1', '1', '0', '1', '0' }, 
//			{ '1', '0', '0', '1', '0' },
//			{ '1', '0', '1', '0', '0' }, 
//			{ '1', '0', '0', '1', '1' } };
		char[][] grid = new char[][] { 
			{ '1', '1', '1', '1', '1' }, 
			{ '1', '1', '1', '1', '1' },
			{ '1', '1', '1', '1', '1' }, 
			{ '1', '1', '1', '1', '1' } };

		System.out.println("Num of island is:" + test.numIslands(grid));
	}
}
