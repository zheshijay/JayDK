package algo.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import algo.mianshibaodian.Q1625LRUCache;

public class LC0146LRU_SingleLinkedNode {

	private int capacity;
	private Map<Integer, ListNode> map; // key -> node.pre
	private ListNode head; // dummy
	private ListNode tail;

	public LC0146LRU_SingleLinkedNode(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>();
		head = new ListNode(-1, -1);
		tail = head;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			// map中存放的是要找的节点的前驱
			ListNode pre = map.get(key);
			ListNode cur = pre.next;

			// 把当前节点删掉并移到尾部
			if (cur != tail) { // 如果已经是tail 就没有必要改了
				pre.next = cur.next;
				// 更新它后面 node 的前驱
				map.put(cur.next.key, pre);
				map.put(cur.key, tail);
				moveToTail(cur);
			}
			return cur.val;
		}

		return -1;
	}

	public void put(int key, int value) {
		if (get(key) != -1) {
			map.get(key).next.val = value;
			return;
		}
		// 若不存在则 new 一个
		ListNode node = new ListNode(key, value);
		// 新 node 的 pre 是 tail
		map.put(key, tail);
		moveToTail(node);

		if (map.size() > capacity) {
			map.remove(head.next.key); // 从map删除

			map.put(head.next.next.key, head); // 修改下一个元素的pre结点为head

			head.next = head.next.next; // 更改指针
		}
	}

	private void moveToTail(ListNode node) {
		node.next = null;
		tail.next = node;
		tail = tail.next;
	}

	// 定义单链表节点
	private class ListNode {
		int key, val;
		ListNode next;

		public ListNode(int key, int val) {
			this.key = key;
			this.val = val;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		Q1625LRUCache cache = new Q1625LRUCache(2 /* 缓存容量 */ );

		cache.put(1, 1);
		cache.put(2, 2);
		cache.get(1); // 返回 1
		cache.put(3, 3); // 该操作会使得密钥 2 作废
		cache.get(2); // 返回 -1 (未找到)
		cache.put(4, 4); // 该操作会使得密钥 1 作废
		cache.get(1); // 返回 -1 (未找到)
		cache.get(3); // 返回 3
		cache.get(4); // 返回 4

		Map<Integer, Integer> testMap = new LinkedHashMap<>();

		testMap.put(1, 1);
		testMap.put(2, 2);
		testMap.put(3, 3);
		testMap.put(4, 4);
		System.out.println(testMap);

		testMap.remove(1);
		testMap.put(1, 1);

		System.out.println(testMap);

	}

}
