package algo.roblox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindRectangles {
	
	int[] dx = new int[] {0,1,0,-1};
	int[] dy = new int[] {1,0,-1,0};
	
	List<int[][]> findOneRectange(int[][] grid){
		int length = grid.length, height = grid[0].length;
		
		List<int[][]> res = new ArrayList<>();
		
		for(int i=0; i<length; i++) {
			for(int j=0; j<height; j++) {
				if (grid[i][j] == 0) {
					int[] topLeft = new int[] {i, j};
					
					int m = i;
					int n = j;
					while(grid[i][n] == 0 && n < height) {
						n++;
					}
					
					while(grid[m][j] == 0 && m <= length) {
						m++;
					}
				
					
					int[] bottomRight = new int[] {m-1, n-1};
					
					res.add(new int[][] {topLeft,bottomRight});
					return res;
				}
			}
		}
		return res;
	}
	
	List<int[][]> findMultipleRectange(int[][] grid){
		int length = grid.length, height = grid[0].length;
		
		List<int[][]> res = new ArrayList<>();
		
		for(int i=0; i<length; i++) {
			for(int j=0; j<height; j++) {
				if (grid[i][j] == 0) {
					int[] topLeft = new int[] {i, j};
					
					int m = i;
					int n = j;
					while(grid[i][n] == 0 && n < height) {
						n++;
					}
					
					while(grid[m][j] == 0 && m <= length) {
						m++;
					}
					
					// clear the rectange
					for(int h = 0; h < m; h++) {
						for(int k = 0; k < n; k++) {
							grid[h][k] = 1;
						}
					}

					int[] bottomRight = new int[] {m-1, n-1};
					res.add(new int[][] {topLeft,bottomRight});
				}
			}
		}
		return res;
	}
	
	List<int[][]> findMultipleShapes(int[][] grid){
		int length = grid.length, height = grid[0].length;
		
		List<int[][]> res = new ArrayList<>();
		
		for(int i=0; i<length; i++) {
			for(int j=0; j<height; j++) {
				if (grid[i][j] == 0) {
					int[] oneCell = new int[] {i, j};
					res.add(new int[][] {oneCell,null});
					// dfs and then clear the shape
					dfs(grid, i, j);
				}
			}
		}
		return res;
	}

	void dfs(int[][] grid, int x, int y){
		grid[x][y] = 1;
		
		for(int k=0; k<4; k++) {
			int nx = x + dx[k], ny = y + dy[k];
			if (nx >=0 && nx <grid.length && ny >=0 && ny <=grid[0].length && grid[nx][ny]==0) {
				dfs(grid, nx, ny);
			}
		}
	}

	public static void main(String[] args) {
		int[][] grid = new int[][] {
			 	{1, 1, 1, 1, 1, 1, 1},
			    {1, 1, 1, 1, 0, 1, 1},
			    {1, 1, 1, 0, 0, 0, 1},
			    {1, 1, 1, 0, 1, 0, 1},
			    {1, 1, 1, 1, 1, 1, 1},
			    {1, 1, 0, 1, 1, 1, 1},
			    {1, 1, 0, 0, 1, 1, 1},
			    {1, 1, 0, 1, 1, 1, 1}
		};
		
		FindRectangles test = new FindRectangles();
//		List<int[][]> res = test.findOneRectange(grid);
//		System.out.println("res: " + Arrays.deepToString(res.toArray()));
		
//		List<int[][]> res = test.findMultipleRectange(grid);
//		System.out.println("res: " + Arrays.deepToString(res.toArray()));
		
		List<int[][]> res = test.findMultipleShapes(grid);
		System.out.println("res: " + Arrays.deepToString(res.toArray()));
		
	}
	
	
}


