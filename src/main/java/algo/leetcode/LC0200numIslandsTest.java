package algo.leetcode;

public class LC0200numIslandsTest {

	
	int[][] DIRS = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};

	public int getIslands(char[][] grid) {
		int len = grid.length, wid = grid[0].length, count = 0;
		for(int x=0; x< len; x++) {
			for(int y=0; y< wid; y++) {
				if (grid[x][y] == '1') {
					dfs(grid, x, y);
					count++;
				}
			}
		}
		
		return count;
	}
	
	private void dfs(char[][] grid, int x, int y) {
		grid[x][y] = '0';
		int len = grid.length, wid = grid[0].length;
		for(int[] dir: DIRS) {
			int nx = x + dir[0], ny = y + dir[1];
			if (nx >=0 && nx < len && ny >=0 && ny < wid && grid[nx][ny]=='1') {
				dfs(grid, nx, ny);
			}
		}
	}

	public static void main(String[] args) {
		LC0200numIslandsTest test = new LC0200numIslandsTest();
		char[][] grid = new char[][]{
				{ '1', '1', '0', '1', '0'}, 
				{ '1', '0', '1', '1', '0' },
				{ '1', '0', '1', '0', '0' },
				{ '1', '0', '0', '1', '1' } };

		System.out.println("Num of island is:" + test.getIslands(grid));
	}
}
