package algo.backtracking;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;


public class Maze {


	public static int[][] maze = new int[][]
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

		public static Queue<Node> q = new LinkedList<Node>();
	
		public static Node getPathBFS(int x, int y, int exist) {

			Set<Node> visited = new HashSet<>();
			
			q.add(new Node(x,y, null));
			
			while(!q.isEmpty()) {

				Node n = q.poll();
				System.out.println(" poll n: " + n);
				System.out.println(" visited: " + visited);
				
				if (maze[n.x][n.y] == exist) {
					System.out.println("Exit is reached!");
					return n;
				}
				
				if(isValid(n.x+1,n.y, exist)) { //go right
					Node nextP = new Node(n.x+1,n.y, n);
					if(!visited.contains(nextP)){visited.add(nextP); q.add(nextP);}
				}

				if(isValid(n.x-1,n.y,exist)) {  //go down
					Node nextP = new Node(n.x-1,n.y, n);
					if(!visited.contains(nextP)){visited.add(nextP); q.add(nextP);}
				}

				if(isValid(n.x,n.y+1,exist)) {  //go left
					Node nextP = new Node(n.x,n.y+1, n);
					if(!visited.contains(nextP)){visited.add(nextP); q.add(nextP);}
				}

				if(isValid(n.x,n.y-1,exist)) {   //go up
					Node nextP = new Node(n.x,n.y-1, n);
					if(!visited.contains(nextP)){visited.add(nextP); q.add(nextP);}
				}
			}
			return null;
		}

		public static boolean isValid(int x, int y, int exist) {
			if((x >= 0 && x < maze.length) && (y >= 0 && y < maze[x].length) && (maze[x][y] != 0 || maze[x][y] == exist)) {
				return true;
			}
			return false;
		}

		public static void main(String[] args) {

			Node p = getPathBFS(0,0,99);

			System.out.println("-------------> Print maze: ");
			for (int i = 0; i < maze.length; i++) {
				for (int j = 0; j < maze[i].length; j++) {
					System.out.print(maze[i][j] + "|");
				}
				System.out.println();
			}

			System.out.println("-------------> Print path: ");
			
			if(p!=null){
				while(p.getParent() != null) {
					System.out.print(maze[p.x][p.y] + "->");
					p = p.getParent();
				}
				
				System.out.print(maze[p.x][p.y]); //print the start node
			}else{
				System.out.print("not found");
			}
			

		}


}
