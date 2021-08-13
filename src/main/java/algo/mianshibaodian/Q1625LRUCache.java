package algo.mianshibaodian;

import java.util.HashMap;
import java.util.LinkedList;

public class Q1625LRUCache {

	/*
	 * Solution 1: 使用 LinkedHashMap
	 */
//	int capacity;
//	Map<Integer, Integer> map;
//
//	public Q1625LRUCache(int capacity) {
//		this.capacity = capacity;
//		map = new LinkedHashMap<>();
//	}
//
//	public int get(int key) {
//		if (!map.containsKey(key)) {
//			return -1;
//		}
//		// 先删除旧的位置，再放入新位置
//		Integer value = map.remove(key);
//		map.put(key, value);
//		return value;
//	}
//
//	public void put(int key, int value) {
//		if (map.containsKey(key)) {
//			map.remove(key);
//			map.put(key, value);
//			return;
//		}
//		map.put(key, value);
//		// 超出capacity，删除最久没用的,利用迭代器删除第一个
//		if (map.size() > capacity) {
//			map.remove(map.entrySet().iterator().next().getKey());
//		}
//	}

	/*
	 * Solution 2: 使用双链表+HashMap
	 */
//	    private int capacity;
//	    private Map<Integer, ListNode> map; //key->node
//	    private ListNode head;  // dummy head
//	    private ListNode tail;  // dummy tail
//
//	    public Q1625LRUCache(int capacity) {
//	        this.capacity = capacity;
//	        map = new HashMap<>();
//	        head = new ListNode(-1, -1);
//	        tail = new ListNode(-1, -1);
//	        head.next = tail;
//	        tail.pre = head;
//	    }
//
//	    public int get(int key) {
//	        if (!map.containsKey(key)) {
//	            return -1;
//	        }
//	        ListNode node = map.get(key);
//	        // 先删除该节点，再接到尾部
//	        node.pre.next = node.next;
//	        node.next.pre = node.pre;
//	        moveToTail(node);
//
//	        return node.val;
//	    }
//
//	    public void put(int key, int value) {
//	        // 直接调用这边的get方法，如果存在，它会在get内部被移动到尾巴，不用再移动一遍,直接修改值即可
//	        if (get(key) != -1) {
//	            map.get(key).val = value;
//	            return;
//	        }
//	        // 若不存在，new一个出来,如果超出容量，把头去掉
//	        ListNode node = new ListNode(key, value);
//	        map.put(key, node);
//	        moveToTail(node);
//
//	        if (map.size() > capacity) {
//	            map.remove(head.next.key);
//	            head.next = head.next.next;
//	            head.next.pre = head;
//	        }
//	    }
//
//	    // 把节点移动到尾巴
//	    private void moveToTail(ListNode node) {
//	        node.pre = tail.pre;
//	        tail.pre = node;
//	        node.pre.next = node;
//	        node.next = tail;
//	    }
//
//	    // 定义双向链表节点
//	    private class ListNode {
//	        int key;
//	        int val;
//	        ListNode pre;
//	        ListNode next;
//
//	        public ListNode(int key, int val) {
//	            this.key = key;
//	            this.val = val;
//	            pre = null;
//	            next = null;
//	        }
//	    }
//	    
//	    
//	    /*
//	     * Solution 3: 使用单链表
//	     */
//	    
//	    private int capacity;
//	    private Map<Integer, ListNode> map; //key -> node.pre
//	    private ListNode head;  // dummy
//	    private ListNode tail;
//
//	    public Q1625LRUCache(int capacity) {
//	        this.capacity = capacity;
//	        map = new HashMap<>();
//	        head = new ListNode(-1, -1);
//	        tail = head;
//	    }
//
//	    public int get(int key) {
//	        if (!map.containsKey(key)) {
//	            return -1;
//	        }
//	        // map中存放的是要找的节点的前驱
//	        ListNode pre = map.get(key);
//	        ListNode cur = pre.next;
//
//	        // 把当前节点删掉并移到尾部
//	        if (cur != tail) {
//	            pre.next = cur.next;
//	            // 更新它后面 node 的前驱
//	            map.put(cur.next.key, pre); 
//	            map.put(cur.key, tail);
//	            moveToTail(cur);
//	        }
//	        return cur.val;
//	    }
//
//	    public void put(int key, int value) {
//	        if (get(key) != -1) {
//	            map.get(key).next.val = value;
//	            return;
//	        }
//	        // 若不存在则 new 一个
//	        ListNode node = new ListNode(key, value);
//	        // 当前 node 的 pre 是 tail
//	        map.put(key, tail); 
//	        moveToTail(node);
//
//	        if (map.size() > capacity) {
//	            map.remove(head.next.key);
//	            map.put(head.next.next.key, head);
//	            head.next = head.next.next;
//	        }
//	    }
//
//	    private void moveToTail(ListNode node) {
//	        node.next = null;
//	        tail.next = node;
//	        tail = tail.next;
//	    }
//
//	    // 定义单链表节点
//	    private class ListNode {
//	        int key, val;
//	        ListNode next;
//
//	        public ListNode(int key, int val) {
//	            this.key = key;
//	            this.val = val;
//	            this.next = null;
//	        }
//	    }

	/*
	 * Solution
	 */
	    private int capacity;
	    private HashMap<Integer,Integer> map;
	    private LinkedList<Integer> list;
	    public Q1625LRUCache(int capacity) {
	        this.capacity=capacity;
	        map=new HashMap<>();
	        list=new LinkedList<>();
	    }
	    
	    public int get(int key) {
	        if(map.containsKey(key)){
	            list.remove((Integer)key);
	            list.addLast(key);
	            return map.get(key);
	        }
	        return -1;
	    }
	    
	    public void put(int key, int value) {
	        if(map.containsKey(key)){
	            list.remove((Integer)key);
	            list.addLast(key);
	            map.put(key,value);
	            return;
	        }
	        if(list.size()==capacity){
	            map.remove(list.removeFirst());
	            map.put(key,value);
	            list.addLast(key);
	        }
	        else{
	            map.put(key,value);
	            list.addLast(key);
	        }
	    }
//
//	作者：lai-di-lin
//	链接：https://leetcode-cn.com/problems/lru-cache-lcci/solution/hashmaplinkedlistshi-xian-lrucache-by-lai-di-lin/
//	来源：力扣（LeetCode）
//	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

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

//		Map<Integer, Integer> testMap = new LinkedHashMap<>();
//
//		testMap.put(1, 1);
//		testMap.put(2, 2);
//		testMap.put(3, 3);
//		testMap.put(4, 4);
//		System.out.println(testMap);
//
//		testMap.remove(1);
//		testMap.put(1, 1);
//
//		System.out.println(testMap);

	}

}
