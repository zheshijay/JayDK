package algo.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RobotEscape {
	 int[] dx = new int[] { 1, 0, -1, 0 };
	 int[] dy = new int[] { 0, 1, 0, -1 };

	 public int[] getPath(char[][] grid, int[] start) {
		 	List<Integer> res = new ArrayList<>();
		 	int length = grid.length, height = grid[0].length;
		 	
		 	for (int i=0; i< length; i++) {
		 		for (int j=0; j< height; j++) {
			 		if (grid[i][j] == '.') {
			 			List<int[]> path = new ArrayList<>();
			 			bfs(grid, new int[] {i, j}, start, path);
			 			res.add(path.size() == 0? -1:path.size());
			 		}		
			 	}
		 	}

		 	int[] ret = new int[res.size()];
		 	int index = 0;
		 	for(int num: res) {
		 		ret[index++] = num;
		 	}
		 	
			return ret;
		}

	void bfs(char[][] grid, int[] target, int[] start, List<int[]> path) {
		if (start[0] == target[0] && start[1] == target[1]) {
			return;
		}
		
		
		
		for(int i =0; i < 4; i++) {
			int x = start[0] + dx[i], y = start[1] + dy[1];
			if (x == target[0] && y == target[1]) {
				return;
			}

			System.out.println("x:" + x);
			System.out.println("y:" + y);
			if (x >=0 && x < grid.length && y >=0 && y < grid[0].length && grid[x][y] == '.') {
				path.add(new int[] {x, y});
				bfs(grid, target, new int[] {x, y}, path);
			}
		}
	}
	 
	public static void main(String[] args) {
		RobotEscape test = new RobotEscape();
		char[][] grid = new char[][] {
			{'W','W','W','W'},
			{'.','W','.','W'},
			{'W','W','.','W'},
			{'W','S','.','.'}
		};
		
		int[] res = test.getPath(grid, new int[] {3, 1});
		System.out.println("res:" + Arrays.toString(res));
	}
}
