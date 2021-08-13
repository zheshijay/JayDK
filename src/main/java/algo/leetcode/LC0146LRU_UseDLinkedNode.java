package algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC0146LRU_UseDLinkedNode {
	int cap;
	Map<Integer, DLinkedNode> map = new HashMap<>(); //用于快速定位node
	DLinkedNode head, tail; // 头尾结点，用于添加删除结点. 头部是最近访问的元素
	
	LC0146LRU_UseDLinkedNode(int cap){
		this.cap = cap;
		head = new DLinkedNode(-1, -1);
		tail = new DLinkedNode(-1, -1);
		head.next = tail;
		tail.pre = head;
	}
	
	class DLinkedNode {
		int key;
		int val;  
		DLinkedNode pre;
		DLinkedNode next;
		DLinkedNode(int key, int val){
			this.key = key;
			this.val = val;
		}
	}
	
	/*
	 * 1. 如果已经存在：移除元素 + 加到最前面 （长度不变，因为是一减一加）
	 * 2. 如果不存在：直接加到前面 （长度有可能超过cap，超过的话就从尾巴移除一位）
	 */
	public void put(int key, int val) {
		if (map.containsKey(key)) {
			DLinkedNode existNode = map.get(key);
			deleteNode(existNode);
			addFirst(existNode);
		} else {
			DLinkedNode newNode = new DLinkedNode(key, val);
			addFirst(newNode);
			
			if (map.size() > cap) {
				removeLast();
			}
		}
	}

	/*
	 * 获取元素
	 * 1. 如果存在：移除并且移动到前面
	 * 2. 如果不存在：返回-1
	 */
	public int get(int key) {
		if (map.containsKey(key)) {
			DLinkedNode existNode = map.get(key);
			deleteNode(existNode);
			addFirst(existNode);
			return existNode.val;
		} else {
			return -1;
		}
	}

	//直接删除node，记得从map里面也删除
	void deleteNode(DLinkedNode node){
		node.pre.next = node.next;
		node.next.pre = node.pre;
		map.remove(node.key);
	}
	
	void addFirst(DLinkedNode node){
		DLinkedNode oldFirst = head.next;
		node.next = oldFirst;
		oldFirst.pre = node;
		head.next = node;
		node.pre = head;
		map.put(node.key, node);
	}
	
	void removeLast(){
		DLinkedNode oldLast = tail.pre;
		oldLast.pre.next = oldLast.next;
		oldLast.next.pre = oldLast.pre;
		map.remove(oldLast.key);
	}

	public static void main(String[] args) {
		LC0146LRU_UseDLinkedNode cache = new LC0146LRU_UseDLinkedNode(2);

//		cache.put(1, 1);
//		cache.put(2, 2);
//		System.out.println(cache.get(1)); // 返回 1
//		cache.put(3, 3); // 该操作会使得密钥 2 作废
//		System.out.println(cache.get(2)); // 返回 -1 (未找到)
//		cache.put(4, 4); // 该操作会使得密钥 1 作废
//		System.out.println(cache.get(1)); // 返回 -1 (未找到)
//		System.out.println(cache.get(3)); // 返回 3
//		System.out.println(cache.get(4)); // 返回 4
		
		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 3);
		cache.put(4, 4);
		cache.put(5, 5);
		cache.put(2, 2);
		
		System.out.println("cache:" + cache.map.keySet());
		System.out.println(cache.get(2));
		System.out.println(cache.get(5));

//		Map<Integer, Integer> testMap = new LinkedHashMap<>();
//
//		testMap.put(1, 1);
//		testMap.put(2, 2);
//		testMap.put(3, 3);
//		testMap.put(4, 4);
//		System.out.println(testMap);

//		testMap.remove(1);
//		testMap.put(1, 1);
//
//		System.out.println(testMap);

	}

}
