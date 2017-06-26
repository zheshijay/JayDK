package algo.combination_and_permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 
 * recursion + backtracking
 * 
 */

public class AllSubSet {
	public List<List<Character>> subsets(char[] chars){
		List<List<Character>> res = new ArrayList<>();
		List<Character> subset = new ArrayList<>();
		Arrays.sort(chars);

		System.out.println("Start..." + Arrays.toString(chars));

		this.getSubSet(chars, res, subset, 0);
		return res;
	}

	//[123]  ->    [] [1] [12] [123] [13] [2] [23] [3]
	
	// 1. 递归的定义：在 Nums 中找到所有以 subset 开头的的集合，并放到 results (res)
	private void getSubSet(char[] nums, List<List<Character>> res, List<Character> subset, int start){

		 // 2. 递归的拆解
        // deep copy
        // results.add(subset);
		
//		System.out.println("adding" + subset);
		res.add(new ArrayList<Character>(subset));

		System.out.println("after adding subset, res:" + res);

		for(int i=start; i<nums.length;i++){
			subset.add(nums[i]);
			this.getSubSet(nums, res, subset, i+1);
			subset.remove(subset.size()-1);
		}
		
		
		return; //3. base case, recursion exist
	}

	public static void main(String[] args){
		AllSubSet test = new AllSubSet();
		List<List<Character>> res = test.subsets("abc".toCharArray());
		System.out.println(res);
	}
}
