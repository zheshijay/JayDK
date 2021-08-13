package algo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class LC0380RandomizedSet {
	  Map<Integer, Integer> idxMap; // 创建一个Map来保存元素值和下标 （由于这个RandomizedSet是一个set，所以值唯一）
	  List<Integer> list; // 动态数组
	  Random rand = new Random();

	  /** Initialize your data structure here. */
	  public LC0380RandomizedSet() {
	    idxMap = new HashMap();
	    list = new ArrayList();
	  }

	  /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	  public boolean insert(int val) {
	    if (idxMap.containsKey(val)) return false;

	    idxMap.put(val, list.size()); // 放到最后一位
	    list.add(list.size(), val); //保存下标
	    return true;
	  }

	  /** Removes a value from the set. Returns true if the set contained the specified element. */
	  public boolean remove(int val) {
	    if (! idxMap.containsKey(val)) return false;

	    // move the last element to the place idx of the element to delete
	    int lastElement = list.get(list.size() - 1);
	    int idx = idxMap.get(val);
	    list.set(idx, lastElement);
	    idxMap.put(lastElement, idx);
	    // delete the last element
	    list.remove(list.size() - 1);
	    idxMap.remove(val);
	    return true;
	  }

	  /** Get a random element from the set. */
	  public int getRandom() {
	    return list.get(rand.nextInt(list.size()));
	  }
	  
	  @Override
	  public String toString() {
		  return list.toString();
	  }

	// Driver code
	public static void main(String args[]) {
//		LC0380RandomizedSet set = new LC0380RandomizedSet();
//		set.insert(1);
//		System.out.println(set);
		
	List<Integer> list = new ArrayList();
	list.add(1);
	list.add(2);
	list.add(3);
//	list.add(4);
	list.add(list.size(), 4);
	System.out.println(list);
	}
}
