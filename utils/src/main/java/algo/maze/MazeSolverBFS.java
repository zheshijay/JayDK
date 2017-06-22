package algo.maze;
import java.util.Set;
import java.util.List;
import java.util.Queue;
import java.util.Map;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.HashMap;

public class MazeSolverBFS {
	
	// Down Right Up Left
	HashSet<Integer> visited = new HashSet<>();
	
	static class Node{
		 int x;
		 int y;
		 Node parent;
		 int[][] maze;

		Node(int x,int y,int[][] maze, Node parent){
			this.x = x;
			this.y = y;
			this.maze=maze;
			 this.parent = parent;
		}
		 public Node getParent() {
	            return this.parent;
	        }
		 
		public int getX(){
			return this.x;
		}
		public int getY(){
			return this.y;
		}

		@Override public boolean equals(Object o){
			if(o == null){
				return false;
			}
			if(!(o instanceof Node)){
				return false;
			}
			final Node n = (Node)o;
			return ((n.x == x) && (n.y == y));
		}
		
		
		/*
		 * 
		 * Why use 31: I'm not sure, but I would guess they tested some sample of prime numbers and found that 31 gave the best distribution over some sample of possible Strings.
		 * 
		 */
		@Override public int hashCode(){
			int result = 17;
			result = 31*result+x;
			result = 31*result+y;
			return result;
		}
		@Override public String toString(){
			return "("+this.x+","+this.y + ") " + maze[x][y];
		} 
	}   
	
	private boolean isValid(int[][] maze, Node node){
		return (maze[node.x][node.y]!=0 && !visited.contains(node) );
	}

	private Set<Node> getNeighbors(Node current, int[][] maze){
		final int x = current.getX();
		final int y = current.getY();
		final int row = maze.length;
		final int col = maze[0].length;
		
		Set<Node> validNeighbors = new HashSet<Node>();
		List<Node> neighbors = new ArrayList<Node>();
		
		
		if(x+1 < row) neighbors.add(new Node(x+1, y, maze));      //down
		if(y+1 < col) neighbors.add(new Node(x, y + 1, maze));      //right
		if(x-1 >= 0)	neighbors.add(new Node(x-1, y, maze));      //up
		if(y-1 >= 0)	neighbors.add(new Node(x, y-1, maze));      //left
		
		
		System.out.println("neighbors: " + neighbors);
		
		for(Node node:neighbors){
			if(isValid(maze,node)){
				System.out.println("add validNeighbor" + node);
				validNeighbors.add(node);
			}
		}   
		return validNeighbors;  
	}

	private static int[][] createMaze(){
		int[][] maze = {{1, 0, 10, 11, 12 },
						{2, 0, 9, 0, 13 },
						{3, 7, 8, 17, 14 },
						{4, 0, 0, 0, 15 },
						{5, 0, 0, 0, 16 },
						{6, 0, 0, 0, 0 }};

		for(int i=0; i< maze.length; i++){
			for(int j=0; j< maze[i].length; j++){
				System.out.print(maze[i][j] + "  ");
			}
			System.out.println();
		}


		return maze;
	}

	private void printQueue(Set<Node> q){
		for(Node n:q){
			System.out.println("Queue contains node"+ n);
		}
	}

	private void printMap(Map<Node,Node> m){
		for(Map.Entry<Node,Node> entry:m.entrySet()){
			System.out.println("visited contains node "+entry.getKey());
		}
	}
	
	public Set<Node> findPath(int[][] maze, Node start, Node end){
		System.out.println("------------------------findPath");
		
		
		Queue<Node> queue = new LinkedList<Node>();
		
		Set<Node> visited = new LinkedHashSet<Node>();
		System.out.println("enqueue: " + start);
		queue.add(start);
		visited.add(start);
		
		Node current = null;
		while((current = queue.poll())!= null){
			System.out.println("=>dequeue: " + current);
			if(current.equals(end)){
				System.out.println("found target! : " + current);
				return visited;
			}else{
				
				Set<Node> neighbors = getNeighbors(current, maze);
				
				System.out.println("neighbors: " + neighbors);
				
				for(Node node:neighbors){
					System.out.println("enqueue: " + node);
					queue.add(node);
//					Node visitedNode = visited.get(n);
					visited.add(node);
				}
			}
		}
		return visited;
	}
	
	/*
	 * 
	 * 
		int[][] maze = {{1, 0, 1, 1, 1 },
						{1, 0, 1, 0, 1 },
						{1, 1, 1, 1, 1 },
						{1, 0, 0, 0, 1 },
						{1, 0, 0, 0, 1 },
						{0, 0, 0, 0, 1 }};
	 */
	public static void main(String[] args){
		MazeSolverBFS test = new MazeSolverBFS();
		
		//Create a maze array
		int[][] maze = createMaze();

		Node startNode = new Node(0, 0, maze);
		Node endNode = new Node(4, 4, maze);

		Set<Node> path = test.findPath(maze, startNode, endNode);
		
		System.out.println("Path: "+path);      
	}}
