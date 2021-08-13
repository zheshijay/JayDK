package algo.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC0286distanceToNearestGate2 {
	 int WALL = -1, GATE = 0, EMPTY = Integer.MAX_VALUE;
	 int[][] dirs = new int[][] {{0, 1},{-1, 0},{0, -1},{1, 0}}; 
	
	public void wallsAndGates(int[][] rooms) {
		// find all the gates, and then do BFS for gates
		
		   int m = rooms.length;
		    if (m == 0) return;
		    int n = rooms[0].length;
		    Queue<int[]> q = new LinkedList<>();
		    for (int row = 0; row < m; row++) {
		        for (int col = 0; col < n; col++) {
		            if (rooms[row][col] == GATE) {
		                q.add(new int[] { row, col });
		            }
		        }
		    }
		    
		    while (!q.isEmpty()) {
		        int[] point = q.poll();
		        int row = point[0];
		        int col = point[1];
		        for (int[] direction : dirs) {
		            int r = row + direction[0];
		            int c = col + direction[1];
		            if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != EMPTY) {
		                continue;
		            }
		            rooms[r][c] = rooms[row][col] + 1;
		            q.add(new int[] { r, c });
		        }
		    }
		    
		
	}

	private int bfs(int[][] rooms, int startX, int startY) {
		
		int len = rooms.length, wid = rooms[0].length;
	    Queue<int[]> q = new LinkedList<>();
	    q.add(new int[] {startX, startY});
	    
	    int[][] dis = new int[len][wid];
	    while(!q.isEmpty()) {
	    	int[] cell = q.poll();
	    	int x = cell[0], y = cell[1];
	    	
	    	for(int i = 0; i< 4; i++) {
	    		int nx = cell[0] + dirs[i][0], ny = cell[1] + dirs[i][1];
	    		
	    		System.out.println("nx:" + nx + "|ny:" + ny);
	    		if (nx <0 || nx >= len || ny <0 || ny >=wid || rooms[nx][ny] == WALL || dis[nx][ny] != 0) {
	    			continue;
	    		}
	    		
	    		dis[nx][ny] = dis[x][y] + 1;
	    		if (rooms[nx][ny] == GATE) {
	    			return dis[nx][ny];
	    		}
	    		
	    		q.add(new int[] {nx, ny});
	    	}
	    }
	    return Integer.MAX_VALUE;
	}

	// Driver code
	public static void main(String args[]) {
		LC0286distanceToNearestGate2 test = new LC0286distanceToNearestGate2();
		
		int[][] rooms = new int[][] {
			{2147483647,-1,0,2147483647},
			{2147483647,2147483647,2147483647,-1},
			{2147483647,-1,2147483647,-1},
			{0,-1,2147483647,2147483647}
		};
		
		test.wallsAndGates(rooms);
		System.out.println("rooms:" + Arrays.deepToString(rooms));
		
	}
}
