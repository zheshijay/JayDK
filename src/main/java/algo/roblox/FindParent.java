package algo.roblox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class FindParent {

	List<Integer> findNodesWithZeroOrOneParent(int[][] edges) {
		List<Integer> res = new ArrayList<>();

		if (edges == null || edges.length == 0) {
			return res;
		}

		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int[] edge : edges) {
			if (map.containsKey(edge[1])) {
				map.get(edge[1]).add(edge[0]);
			} else {
				Set<Integer> set = new HashSet<>();
				set.add(edge[0]);
				map.put(edge[1], set);
			}
		}

		for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
			if (entry.getValue().size() == 0 || entry.getValue().size() == 1) {
				res.add(entry.getKey());
			}
		}
		return res;

	}

	boolean hasCommonAncestor(int[][] edges, int x, int y) {

		if (edges == null || edges.length == 0) {
			return false;
		}

		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int[] edge : edges) {
			if (map.containsKey(edge[1])) {
				map.get(edge[1]).add(edge[0]);
			} else {
				Set<Integer> set = new HashSet<>();
				set.add(edge[0]);
				map.put(edge[1], set);
			}
		}

		Set<Integer> xAncestors = allAncestors(map, x);
		Set<Integer> yAncestors = allAncestors(map, y);

		System.out.println("xAncestors:" + xAncestors);
		System.out.println("yAncestors:" + yAncestors);

		for (int xA : xAncestors) {
			if (yAncestors.contains(xA)) {
				return true;
			}
		}

		return false;
	}

	// 用的BFS找出所有ancestor，也可以用DFS
	private static Set<Integer> allAncestors(Map<Integer, Set<Integer>> map, int a) {
		Set<Integer> set = new HashSet<>();
		Queue<Integer> queue = new LinkedList<>();
		queue.add(a);
		while (!queue.isEmpty()) {
			int cur = queue.remove();
			set.add(cur);
			Set<Integer> parents = map.get(cur);
			if (parents == null)
				continue;
			for (int p : parents) {
				queue.add(p);
			}
		}
		return set;
	}

	// 第三问：一个点的最远祖先，感觉就是用DFS做

	int earliestAncestor(int[][] edges, int x) {
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int[] edge : edges) {
			if (map.containsKey(edge[1])) {
				map.get(edge[1]).add(edge[0]);
			} else {
				Set<Integer> set = new HashSet<>();
				set.add(edge[0]);
				map.put(edge[1], set);
			}
		}

		int[] res = new int[2];
		dfs(map, x, res, 0);

		System.out.println("res:" + res);

		return res[1];
	}

	// int[] res来作为helper int[]， res[0] = 当前level, res[1]就是当前level的ancestor
	public static void dfs(Map<Integer, Set<Integer>> map, int a, int[] res, int level) {
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
		FindParent test = new FindParent();

		int[][] edges = new int[][] { { 1, 4 }, { 1, 5 }, { 2, 5 }, { 3, 6 }, { 6, 7 } };
//		List<Integer> res = test.findNodesWithZeroOrOneParent(edges);

//		boolean hasCA = test.hasCommonAncestor(edges, 4, 6);

		int earliestAncestor = test.earliestAncestor(edges, 7);

		System.out.println("earliestAncestor:" + earliestAncestor);

	    int[] nums = new int[]{1,5,4,2,1};
	
		Arrays.sort(nums, (x, y)->{return x - y;});
	}

}
