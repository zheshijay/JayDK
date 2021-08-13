package algo.jianzhioffer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*
字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。

 

示例 1：

输入: s = "abcdefg", k = 2
输出: "cdefgab"
示例 2：

输入: s = "lrloseumgh", k = 6
输出: "umghlrlose"

 */

public class Q059MaxQueue {
	/*
	 * Solution 1
	 */
//	 int[] q = new int[20000];
//	    int begin = 0, end = 0;
//
//	    public Q059MaxQueue() {
//
//	    }
//	    
//	    public int max_value() {
//	        int ans = -1;
//	        for (int i = begin; i != end; ++i) {
//	            ans = Math.max(ans, q[i]);
//	        }
//	        return ans;
//	    }
//	    
//	    public void push_back(int value) {
//	        q[end++] = value;
//	    }
//	    
//	    public int pop_front() {
//	        if (begin == end) {
//	            return -1;
//	        }
//	        return q[begin++];
//	    }
	    
	    /*
		 * Solution 2
		 */
	    Queue<Integer> q;
	    Deque<Integer> d;

	    public Q059MaxQueue() {
	        q = new LinkedList<Integer>();
	        d = new LinkedList<Integer>();
	    }
	    
	    public int max_value() {
	        if (d.isEmpty()) {
	            return -1;
	        }
	        return d.peekFirst();
	    }
	    
	    public void push_back(int value) {
	        while (!d.isEmpty() && d.peekLast() < value) {
	            d.pollLast();
	        }
	        d.offerLast(value);
	        q.offer(value);
	    }
	    
	    public int pop_front() {
	        if (q.isEmpty()) {
	            return -1;
	        }
	        int ans = q.poll();
	        if (ans == d.peekFirst()) {
	            d.pollFirst();
	        }
	        return ans;
	    }

	    
	    
	    
}