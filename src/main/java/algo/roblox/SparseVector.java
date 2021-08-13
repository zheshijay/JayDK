package algo.roblox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.*;

public class SparseVector {
	int size;
	// store index : value
	Map<Integer, Integer> map;

	public SparseVector(int size) {
		this.size = size;
		this.map = new HashMap<>();
	}

	public void set(int index, int value) {
		if (index >= size) {
			throw new java.lang.Error("out of index!");
		}
		map.put(index, value);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			if (map.containsKey(i)) {
				sb.append(map.get(i));
			} else {
				sb.append("0");
			}
			sb.append(",");
		}
		return sb.toString();
	}

	// get operation
	int get(int key) {
		return map.get(key)==null?-1:map.get(key);
	}

	// add operation
	public SparseVector add(SparseVector v) {
		if (v.size != size) {
			throw new java.lang.Error("Vectors length don't match");
		}
		SparseVector v3 = new SparseVector(v.size);
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int index = entry.getKey();
			int value = entry.getValue();
			v3.map.put(index, v3.map.getOrDefault(index, 0) + value);
		}
		for (Map.Entry<Integer, Integer> entry : v.map.entrySet()) {
			int index = entry.getKey();
			int value = entry.getValue();
			v3.map.put(index, v3.map.getOrDefault(index, 0) + value);
		}
		System.out.println(v3.toString());
		return v3;
	}

	public static void main(String[] args) {
		SparseVector v1 = new SparseVector(10);
		v1.set(0, 1);
		v1.set(3, 2);
		v1.set(4, 3);
//		v1.set(200, 3);

		System.out.println(v1.get(3));
		System.out.println(v1.toString());

//		SparseVector v2 = new SparseVector(5);
//		v2.set(1, 2);
//		v2.set(3, 3);
//		v1.add(v2);
	}

}