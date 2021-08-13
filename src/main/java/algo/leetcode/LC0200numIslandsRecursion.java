package algo.leetcode;

public class LC0200numIslandsRecursion {

	int[] dx = new int[] { 1, 0, -1, 0 };
	int[] dy = new int[] { 0, 1, 0, -1 };

	public int numIslands(char[][] grid) {
		int xLength = grid.length;
		int yLength = grid[0].length;
		int count = 0;

		for (int x = 0; x < xLength; x++) {
			for (int y = 0; y < yLength; y++) {
				System.out.println("x:" + x + "|y:" + y);
				if (grid[x][y] == '1') {
					dfs(grid, x, y);
					count++;
				}
			}
		}
		return count;
	}

	void dfs(char[][] grid, int x, int y) {
		// mark cur cell to 0
		grid[x][y] = '0';
		
		
		// mark cells around
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i], ny = y + dy[i];
			
			System.out.println("x:"+x + "|y:" + y + "|nx:"+nx + "|ny:" + ny);
			if (nx >=0 && nx < grid.length && ny >=0 && ny < grid[0].length && grid[nx][ny] == '1' ) {
//				grid[nx][ny] = '0';
				// Mark 1s
				dfs(grid, nx, ny);
			}
		}
	}
	
	

	
	public static void main(String[] args) {
		LC0200numIslandsRecursion test = new LC0200numIslandsRecursion();
		char[][] grid = new char[][]{
				{ '1', '1', '0', '1', '0'}, 
				{ '1', '0', '0', '1', '0' },
				{ '1', '0', '1', '0', '0' },
				{ '1', '0', '0', '1', '1' } };

		System.out.println("Num of island is:" + test.numIslands(grid));
	}
}
