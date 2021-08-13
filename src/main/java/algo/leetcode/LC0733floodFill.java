package algo.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LC0733floodFill {
	int[] dx = new int[] {1,0,-1,0};
	int[] dy = new int[] {0,-1,0,1};
	
	 public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		 int curColor = image[sr][sc];
		 if (curColor == newColor) {
			 return image;
		 }
		 
		 int len = image.length, wid = image[0].length;
		 image[sr][sc] = newColor;
		 
		 Queue<int[]> queue = new LinkedList<>();
		 queue.offer(new int[] {sr, sc});
		 
		 while(!queue.isEmpty()) {
			 int[] cell = queue.poll();
			 int x = cell[0], y = cell[1];
			 
			 for (int i=0; i< 4; i++) {
				int nx = x + dx[i], ny = y + dy[i];
				if (nx >=0 && nx <len && ny >=0 && ny <wid && image[nx][ny] == curColor) {
					image[nx][ny] = newColor;
					queue.offer(new int[] {nx, ny});
				}
				
			 }
			 
		 }
		 return image;
	 }
	
}
