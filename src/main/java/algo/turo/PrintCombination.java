package algo.turo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintCombination {
	/*
	 * n=length of outer list 1~10000 m=max length of inner list [ [245] [4567]
	 * [23]]
	 * 
	 * Input： 2 4 5 45 67 2 3
	 * 
	 * Output： [[2, 45, 2] [2, 67, 2] [4, 45, 2] … ]
	 * 
	 */

	List<List<Integer>> getSubSet(List<List<Integer>> nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		dfs(nums, 0, res, path);
		return res;
	}

	void dfs(List<List<Integer>> nums, int level, List<List<Integer>> res, List<Integer> path, Integer next){
		
		System.out.println("---> path:" + path);
//		if (path.size() == nums.size()) {
			res.add(new ArrayList<>(path));
//			return;
//		}
//		res.add(new ArrayList<>(path));
		
//		if (level >= nums.size()) return;

		for(int i = level; i < nums.size(); i++) {
			
			for(int j = i; j < nums.get(i).size(); j++) {
				System.out.println("level:" + level + "|val:" + nums.get(i).get(j));
				path.add(nums.get(i).get(j));
				dfs(nums, level + 1, res, path);
				path.remove(path.size()-1);
			}
		}
	}
	
	
	void generatePermutations(List<List<String>> lists, List<String> result, int depth, String current) {
	    if (depth == lists.size()) {
	        result.add(current);
	        return;
	    }

	    for (int i = 0; i < lists.get(depth).size(); i++) {
	        generatePermutations(lists, result, depth + 1, (current + lists.get(depth).get(i)));
	    }
	}
	
	void generatePermutations2(List<List<Integer>> nums, List<List<Integer>> result, List<Integer> path, int depth) {
	    if (depth == nums.size()) {
	        result.add(new ArrayList<>(path));
	        return;
	    }

	    for (int i = 0; i < nums.get(depth).size(); i++) {
	    	path.add(nums.get(depth).get(i));
	        generatePermutations2(nums, result, path, depth + 1);
	        path.remove(path.size()-1);
	    }
	}

	public static void main(String[] args) {
		List<List<Integer>> nums = new ArrayList<>();
		nums.add(Arrays.asList(2, 45, 2));
		nums.add(Arrays.asList(2, 67, 2));
//		nums.add(Arrays.asList(5, 6, 7));
//		nums.add(Arrays.asList(2, 3));

		System.out.println("nums:" + nums);

		PrintCombination test = new PrintCombination();
//		List<List<Integer>> res = test.getSubSet(nums);

		
		
		// 2. test
		List<List<Integer>> lists = new ArrayList<>();
		lists.add(Arrays.asList(2 , 4, 5));
		lists.add(Arrays.asList(45, 67));
		lists.add(Arrays.asList(2, 3));
//		lists.add(Arrays.asList("6", "7"));
//		lists.add(Arrays.asList("8"));
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
//		test.generatePermutations(lists, res, 0, "");
		test.generatePermutations2(lists, res, path, 0);
		System.out.println("res:" + res);

	}

}
