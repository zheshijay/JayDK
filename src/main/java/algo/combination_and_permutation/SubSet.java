package algo.combination_and_permutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subsets
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class SubSet {
	
	/*
	 所有子集:[[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]] 
	 **/
	List<List<Integer>> res1 = new ArrayList<>();
	public List<List<Integer>> getSubSets1(int[] nums) {
		List<Integer> path = new ArrayList<>();
		dfs1(nums, 0, path);
		return res1;
	}
	
	void dfs1(int[] nums, int start, List<Integer> path) {
		res1.add(new ArrayList<>(path));
		for(int i=start; i<nums.length; i++) {
			path.add(nums[i]);
			dfs1(nums, i+1, path);
			path.remove(path.size()-1);
		}
	}
	
	/*
	 固定size子集[[1, 2], [1, 3], [2, 3]]
	 **/
	int k2;
	List<List<Integer>> res2 = new ArrayList<>();
	public List<List<Integer>> getSubSets2(int[] nums, int k2) {
		this.k2 = k2;
		List<Integer> path = new ArrayList<>();
		dfs2(nums, 0, path);
		return res2;
	}
	
	void dfs2(int[] nums, int start, List<Integer> path) {
		if (path.size() == 2) {
			res2.add(new ArrayList<>(path));
			return;
		}
		
		for(int i=start; i<nums.length; i++) {
			path.add(nums[i]);
			dfs2(nums, i+1, path);
			path.remove(path.size()-1);
		}
	}
	
	/*
	  固定size 不可重复自己 
	  子集[[1, 1, 1], [1, 1, 2], [1, 1, 3], [1, 2, 1], [1, 2, 2], [1, 2, 3], [1, 3, 1], 
	  [1, 3, 2], [1, 3, 3], [2, 1, 1], 
	  [2, 1, 2], [2, 1, 3], [2, 2, 1], [2, 2, 2], [2, 2, 3], [2, 3, 1], [2, 3, 2], [2, 3, 3], [3, 1, 1], 
	  [3, 1, 2], [3, 1, 3], [3, 2, 1], 
	  [3, 2, 2], [3, 2, 3], [3, 3, 1], [3, 3, 2], [3, 3, 3]]
	 **/
	int k3;
	List<List<Integer>> res3 = new ArrayList<>();
	public List<List<Integer>> getSubSets3(int[] nums, int k3) {
		this.k3 = k3;
		List<Integer> path = new ArrayList<>();
		dfs3(nums, 0, path);
		return res3;
	}
	
	void dfs3(int[] nums, int start, List<Integer> path) {
		if (path.size() == 3) {
			res3.add(new ArrayList<>(path));
			return;
		}
		
		for(int i=0; i<nums.length; i++) {
			path.add(nums[i]);
			dfs3(nums, i+1, path);
			path.remove(path.size()-1);
		}
	}
	
	/*
	  固定size 不可重复自己子集
	  [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
	 **/
	int k4;
	List<List<Integer>> res4 = new ArrayList<>();
	Set<Integer> seen4;
	public List<List<Integer>> getSubSets4(int[] nums, int k4) {
		this.k4 = k4;
		seen4 = new HashSet<>();
		List<Integer> path = new ArrayList<>();
		dfs4(nums, 0, path);
		return res4;
	}
	
	void dfs4(int[] nums, int start, List<Integer> path) {
		if (path.size() == k4) {
			res4.add(new ArrayList<>(path));
			return;
		}
		
		for(int i=0; i<nums.length; i++) {
			if (!seen4.contains(nums[i])) {
				path.add(nums[i]);
				seen4.add(nums[i]);
				dfs4(nums, i+1, path);
				path.remove(path.size()-1);
				seen4.remove(nums[i]);
			}
			
		}
	}
	
	public static void main(String[] args) {
		SubSet test = new SubSet();
		int[] nums = new int[] { 1, 2, 3 };
		System.out.println("--------------");
		System.out.println("getSubSet1: 所有子集:" + test.getSubSets1(nums));
		System.out.println("getSubSet2: 固定size子集" + test.getSubSets2(nums, 2));
		System.out.println("getSubSet3: 固定size 可重复自己 子集" + test.getSubSets3(nums, 3));
		System.out.println("getSubSet4: 固定size 不可重复自己 子集" + test.getSubSets4(nums, 3));
//		System.out.println("getSubSet3: 固定size 可重复子集" + test.getSubSets3(nums, 3));


	}

}
