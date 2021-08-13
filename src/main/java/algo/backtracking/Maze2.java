package algo.backtracking;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;


public class Maze2 {
	 int[] dx = new int[] { 1, 0, -1, 0 };
	 int[] dy = new int[] { 0, 1, 0, -1 };


	public static int[][] grid = new int[][]
	   {{1, 0, 10, 11,  12 },
		{2, 0, 9,  0,   13 },
		{3, 7, 8,  17,  14 },
		{4, 0, 0,  0,   15 },
		{5, 0, 0,  0,   99 },
		{6, 0, 0,  0,    0 }}; 

		private static class Node {
			int x;
			int y;
			Node parent;
			
			public Node(int x, int y, Node parent) {
				this.x = x;
				this.y = y;
				this.parent = parent;
			}

			public Node getParent() {
				return this.parent;
			}

			public String toString() {
				return "(" + x + "," + y + ")";
			}
			
			@Override
			public int hashCode(){
				return Objects.hash(x,y);
		    }
			
			@Override
			public boolean equals(Object obj) {
				if(! (obj instanceof Node) ) return false;
				
				Node node = (Node) obj;
				
				if( node.x == this.x && node.y == this.y ) return true;
				return false;
			}

		}

		public  Queue<Node> q = new LinkedList<Node>();
	
		public  Node getPathBFS(int x, int y, int exit) {

			Set<Node> visited = new HashSet<>();
			
			q.add(new Node(x,y, null));
			
			while(!q.isEmpty()) {

				Node cur = q.poll();
				System.out.println(" poll cur: " + cur );
//				System.out.println(" poll n: " + n + "" + maze[n.x][n.y]);
				System.out.println(" visited: " + visited);
				
				if (grid[cur.x][cur.y] == exit) {
					System.out.println("Exit is reached!");
					return cur;
				}
				
				for (int i=0; i< 4; i++) {

					int nx = cur.x + dx[i], ny = cur.y + dy[i];
					
		 			if(isValid(nx, ny, exit)) {
						
		 				Node nextP = new Node(nx, ny, cur);
						
						if(!visited.contains(nextP)){
							visited.add(nextP); 
							q.add(nextP);
						}
					}
		 		
				}
				
				
			}
			return null;
		}

		public  boolean isValid(int x, int y, int exist) {
			if((x >= 0 && x < grid.length) 
					&& (y >= 0 && y < grid[x].length) 
					&& (grid[x][y] != 0 || grid[x][y] == exist)) {
				return true;
			}
			return false;
		}

		public static void main(String[] args) {

			Maze2 test = new Maze2();

			System.out.println("-------------> Print maze: ");
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[i].length; j++) {
					System.out.print(grid[i][j] + "|");
				}
				System.out.println();
			}

			System.out.println("-------------> Print path: ");
			Node p = test.getPathBFS(0,0,99);			
			if(p!=null){
				while(p.getParent() != null) {
					System.out.print(grid[p.x][p.y] + "->");
					p = p.getParent();
				}
				
				System.out.print(grid[p.x][p.y]); //print the start node
			}else{
				System.out.print("not found");
			}
			

		}


}
