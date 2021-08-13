package com.jay.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class ReadWriteLockDemo {
	
	private ReadWriteLock lock = new ReentrantReadWriteLock();

	private int number = 0;

	// Read
	public void read() {
		System.out.println(Thread.currentThread().getName() + " + " + number);

	}

	// Write
	public void write(int number) {
		System.out.println(Thread.currentThread().getName());
		this.number = number;

	}
}
