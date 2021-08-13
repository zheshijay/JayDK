package algo.roblox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class FindParentTest {

	private List<Integer> findNodesWithZeroOrOneParent(int[][] edges) {
		List<Integer> res = new ArrayList<>();

		if (edges == null || edges.length == 0) {
			return res;
		}
		
		Map<Integer, Set<Integer>> map = new HashMap<>();
		
		for(int[] edge: edges) {
			if (map.containsKey(edge[1])) {
				map.get(edge[1]).add(edge[0]);
			} else {
				Set<Integer> set = new HashSet<>();
				set.add(edge[0]);
				map.put(edge[1], set);
			}
		}

		for(Map.Entry<Integer, Set<Integer>> entry: map.entrySet()) {
			if (entry.getValue().size() == 0 || entry.getValue().size() == 1) {
				res.add(entry.getKey());
			}
		}
		
		return res;
	}
	
	
	private boolean hasCommonAncestor(int[][] edges, int n1, int n2) {
		
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for(int[] edge: edges) {
			if (map.containsKey(edge[1])) {
				map.get(edge[1]).add(edge[0]);
			} else {
				Set<Integer> set = new HashSet<>();
				set.add(edge[0]);
				map.put(edge[1], set);
			}
		}

		Set<Integer> allAncestors1 = getAllAncestors(map, n1);
		Set<Integer> allAncestors2 = getAllAncestors(map, n2);
		
		System.out.println("all Ancestor of " + n1 + ":" + allAncestors1);
		System.out.println("all Ancestor of " + n2 + ":" + allAncestors2);
		
		return allAncestors1.stream().anyMatch(v->allAncestors2.contains(v));
		
	}

	private Set<Integer> getAllAncestors(Map<Integer, Set<Integer>> map, int n1) {
		Set<Integer> allAncestors = new HashSet<>();
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n1);
		
		while(!queue.isEmpty()) {
			Integer cur = queue.poll();
			allAncestors.add(cur);
			
			Set<Integer> parents = map.get(cur);
			if (parents != null) {
				for(int parent: parents) {
					queue.add(parent);
				}
			}
		}
		return allAncestors;
	}

	private int earliestAncestor(int[][] edges, int n) {
		
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for(int[] edge: edges) {
			if (map.containsKey(edge[1])) {
				map.get(edge[1]).add(edge[0]);
			} else {
				Set<Integer> set = new HashSet<>();
				set.add(edge[0]);
				map.put(edge[1], set);
			}
		}

		// use an array to store the res, [0] is val, [1] is level
		int[] res = new int[2];
		dfs(map, n, res, 0);
		return res[1];
		
	}

	private void dfs(Map<Integer, Set<Integer>> map, int a, int[] res, int level) {
		if (level > res[0]) {
			// find a higher ancestor
			// update highest level and hightes ancestor
			res[0] = level;
			res[1] = a;
		}

		Set<Integer> parents = map.get(a);
		if (parents != null && parents.size() != 0) {
			for (int parent : parents) {
				dfs(map, parent, res, level + 1);
			}
		}
	}


	public static void main(String[] args) {
		FindParentTest test = new FindParentTest();

		int[][] edges = new int[][] { 
			{ 1, 4 }, 
			{ 1, 5 }, 
			{ 2, 5 }, 
			{ 3, 6 }, 
			{ 6, 7 } 
			};
		List<Integer> zeroOrOneParent = test.findNodesWithZeroOrOneParent(edges);
		System.out.println("zeroOrOneParent:" + zeroOrOneParent);

//		boolean hasCommonAncestor = test.hasCommonAncestor(edges, 4, 6);
		boolean hasCommonAncestor = test.hasCommonAncestor(edges, 4, 5);
		
		System.out.println("hasCommonAncestor:" + hasCommonAncestor);
			
		int earliestAncestor = test.earliestAncestor(edges, 7);
		System.out.println("earliestAncestor:" + earliestAncestor);

	}






	


	
}
