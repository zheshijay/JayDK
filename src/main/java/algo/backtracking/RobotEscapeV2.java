package algo.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import algo.backtracking.Maze.Node;

public class RobotEscapeV2 {
	 int[] dx = new int[] { 1, 0, -1, 0 };
	 int[] dy = new int[] { 0, 1, 0, -1 };

	 public int[] getPath(char[][] grid, int[] start) {
		 
		 	List<Integer> res = new ArrayList<>();
		 	Set<Node> visited = new HashSet<>();
		 	
		 	
		 	Queue<Node> q = new LinkedList<Node>();
		 	
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

	 
	public static void main(String[] args) {
		RobotEscapeV2 test = new RobotEscapeV2();
		char[][] grid = new char[][] {
			{'W','W','W','W'},
			{'.','W','.','W'},
			{'W','W','.','W'},
			{'W','S','.','.'}
		};
		
		int[] res = test.getPath(grid, new int[] {3, 1});
		System.out.println("res:" + Arrays.toString(res));
	}
	
	class Node {
		int x;
		int y;
		Node parent;
		Node(int x, int y, Node parent){
			this.x=x;
			this.y=y;
			this.parent=parent;
		}
	}
}

