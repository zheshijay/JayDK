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
	private void getSubSet(char[] nums, List<List<Character>> res, List<Character> subset, int start){

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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<List<Character>> myGetAllSubSet(char[] chars){
		List<List<Character>> res = new ArrayList<>();
		List<Character> subSet = new ArrayList<>();
		
		myGetSubSet(chars, res, subSet, 0);
		
		return res;

	}
	
	
	//1. Original char  2.res set 3.tmpSet  4.start index
	public static void myGetSubSet(char[] chars, List<List<Character>> res, List<Character> subSet, int start ){
		
		res.add(new ArrayList<Character>(subSet));
		
		for( int i=start; i< chars.length; i++ ){
			subSet.add(chars[i]);
			myGetSubSet(chars, res, subSet, i+1);
			subSet.remove(subSet.size()-1);
		}
		return;
	}
	
	
	
	
	
	
	
	
	

	public static void main(String[] args){
		AllSubSet test = new AllSubSet();
		List<List<Character>> res = test.myGetAllSubSet("abc".toCharArray());
		System.out.println(res);
	}
}
