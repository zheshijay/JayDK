package algo.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC0286distanceToNearestGate {
	 int WALL = -1, GATE = 0, EMPTY = Integer.MAX_VALUE;
	 int[][] dirs = new int[][] {{0, 1},{-1, 0},{0, -1},{1, 0}}; 
	
	public void wallsAndGates(int[][] rooms) {
		 if (rooms.length == 0) return;
		int len = rooms.length, wid = rooms[0].length;
		for(int x=0; x<len; x++) {
			for(int y=0; y<wid; y++) {
				if (rooms[x][y] == EMPTY) {
					rooms[x][y] = bfs(rooms, x, y);
				}
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
		LC0286distanceToNearestGate test = new LC0286distanceToNearestGate();
		
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
