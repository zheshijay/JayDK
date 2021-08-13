package algo.leetcode;

import java.util.concurrent.locks.ReentrantLock;

public class LC0622MyCircularQueue {

	private int[] queue;
	private int headIndex;
	private int count;
	private int capacity;

	private ReentrantLock queueLock = new ReentrantLock();

	public LC0622MyCircularQueue(int k) {
		this.capacity = k;
		this.queue = new int[k];
		this.headIndex = 0;
		this.count = 0;
	}

	public boolean enQueue(int value) {
	
		queueLock.lock();
		
		try {
			if (this.count == this.capacity)
				return false;
			this.queue[(this.headIndex + this.count) % this.capacity] = value;
			this.count += 1;
		} finally {
			queueLock.unlock();
		}
		return true;
	}

	public boolean deQueue() {
		if (this.count == 0)
			return false;
		this.headIndex = (this.headIndex + 1) % this.capacity;
		this.count -= 1;
		return true;
	}

	public int Front() {
		if (this.count == 0)
			return -1;
		return this.queue[this.headIndex];
	}

	public int Rear() {
		if (this.count == 0)
			return -1;
		int tailIndex = (this.headIndex + this.count - 1) % this.capacity;
		return this.queue[tailIndex];
	}

	public boolean isEmpty() {
		return (this.count == 0);
	}

	public boolean isFull() {
		return (this.count == this.capacity);
	}

	public static void main(String[] args) {

	}
}
