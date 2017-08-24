package algo.two_pointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class TwoSum_DataStructure {
	
	/*
	 * 
	 * 
	 * Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

For example,

add(1); 
add(3); 
add(5);
find(4) -> true
find(7) -> false
	 */
	
	static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	public void add(int val){
		if(map.containsKey(val)) return;
		else map.put(val, 1);
	}
	
	public boolean find(int k){
		Set<Integer> keySet = map.keySet();
		Iterator<Integer> it = keySet.iterator();
		
		while(it.hasNext()){
			Integer curKey = it.next();
			Integer diff = k - curKey;
			if(map.containsKey(diff)) return true;	
		}
		return false;
	}

	
	public static void main(String args[]){
		TwoSum_DataStructure twoSum = new TwoSum_DataStructure();
		twoSum.add(1);
		twoSum.add(2);
		twoSum.add(3);
		
		
		System.out.println(twoSum.find(33));

	}
}
