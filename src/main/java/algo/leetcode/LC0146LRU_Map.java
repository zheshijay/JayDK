package algo.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class LC0146LRU_Map {
	int cap;
	Map<Integer, Integer> map;

	LC0146LRU_Map(int cap){
		this.cap = cap;
		map = new LinkedHashMap<>(); // LinkedHashMap 保持插入顺序，put永远都在最后
	}

	public void put(int key, int val) {
		if (map.containsKey(key)) {
			map.remove(key);
		} else {
			map.put(key, val);
			if (map.size() > cap) {
				map.remove(map.keySet().iterator().next()); // 删除第一个
			}
		}
	}
	
	public int get(int key) {
		if (map.containsKey(key)) {
			int val = map.get(key);
			map.remove(key);
			map.put(key, val);
			return val;
				
		} else {
			return -1;
		}
	}
	

	public static void main(String[] args) {
		LC0146LRU_Map cache = new LC0146LRU_Map(3);

		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(1, 1);
		
		System.out.println("cache:" + cache.map);
		System.out.println("cache.get(1):" + cache.get(1));
		System.out.println("cache:" + cache.map);
		
//		cache.put(3, 3); // 该操作会使得密钥 2 作废
//		System.out.println(cache.get(2)); // 返回 -1 (未找到)
//		cache.put(4, 4); // 该操作会使得密钥 1 作废
//		System.out.println(cache.get(1)); // 返回 -1 (未找到)
//		System.out.println(cache.get(3)); // 返回 3
//		System.out.println(cache.get(4)); // 返回 4
		
//		cache.put(1, 1);
//		cache.put(2, 2);
//		cache.put(3, 3);
//		cache.put(4, 4);
//		cache.put(5, 5);
////		cache.put(2, 2);
//		
//		System.out.println("cache:" + cache.map.keySet());
//		System.out.println(cache.get(3));
//		System.out.println(cache.get(5));

//		Map<Integer, Integer> testMap = new LinkedHashMap<>();
//
//		testMap.put(1, 1);
//		testMap.put(2, 2);
//		testMap.put(3, 3);
//		testMap.put(4, 4);
//		testMap.remove(2);
//		testMap.put(2, 2);
//
//		System.out.println(testMap);


//		testMap.put(1, 1);
//
//		System.out.println(testMap);

	}

}
