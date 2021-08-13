package algo.leetcode;


public class LC0463islandPerimeter {
	int[][] DIRS = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int islandPerimeter(int[][] grid) {
        int len = grid.length, wid = grid[0].length;
        int ans = 0;
        for (int x = 0; x < len; ++x) {
            for (int y = 0; y < wid; ++y) {
                if (grid[x][y] == 1) {
                    int cnt = 0;
                    for(int[] dir: DIRS) {
                    	int nx = x + dir[0], ny = y + dir[1];
                    	 if (nx < 0 || nx >= len || ny < 0 || ny >= wid || grid[nx][ny] == 0) {
                             cnt += 1;
                         }
                    }
                    ans += cnt;
                }
            }
        }
        return ans;
    }
}
