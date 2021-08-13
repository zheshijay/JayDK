package algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC0146LRU_UseDLinkedNode3 {
	int cap;
	DNode head, tail;
	Map<Integer, DNode> map;

	LC0146LRU_UseDLinkedNode3(int cap) {
		this.cap = cap;
		head = new DNode(-1, -1);
		tail = new DNode(-1, -1);
		map = new HashMap<Integer, DNode>();
		
		// 收尾相连，避免下面操作的NPE
		head.next = tail;
		tail.pre = head;
	}

	void put(int key, int val) {
		if (map.containsKey(key)) {
			DNode node = map.get(key);
			deleteNode(node);
			moveToFirst(node);
		} else {
			DNode node = new DNode(key, val);
			moveToFirst(node);
			if (map.size() > cap) {
				removeLast();
			}
		}
	}

	int get(int key) {
		if (map.containsKey(key)) {
			DNode node = map.get(key);
			deleteNode(node);
			moveToFirst(node);
			return node.val;
		}
		return -1;
	}

	private void moveToFirst(DNode node) {
		DNode oldFirst = head.next;
		node.next = oldFirst;
		oldFirst.pre = node;
		node.pre = head;
		head.next = node;

		map.put(node.key, node);
	}

	private void removeLast() {
		DNode oldLast = tail.pre;
		oldLast.pre.next = tail;
		oldLast.next.pre = oldLast.pre;
		map.remove(oldLast.key);
	}

	private void deleteNode(DNode node) {
		node.pre.next = node.next;
		node.next.pre = node.pre;
		map.remove(node.key);
	}
	
	public static void main(String[] args) {
		LC0146LRU_UseDLinkedNode3 cache = new LC0146LRU_UseDLinkedNode3(2);

		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 3);
		cache.put(4, 4);
		cache.put(5, 5);
//		cache.put(2, 2);

		System.out.println("cache:" + cache.map.keySet());
		System.out.println(cache.get(3));
		System.out.println(cache.get(5));

	}
}

class DNode {
	int key, val;
	DNode pre, next;

	DNode(int key, int val) {
		this.key = key;
		this.val = val;
	}
}
