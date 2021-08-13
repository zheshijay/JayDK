package com.jay.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestCallable {
	public static void main(String[] args) {

		Ticket ticket = new Ticket();

		new Thread(ticket, "#1 窗口").start();
		new Thread(ticket, "#2 窗口").start();
		new Thread(ticket, "#3 窗口").start();

	}

}

class Ticket implements Runnable {
	private int ticket = 10;
	private Lock lock = new ReentrantLock();
	
	@Override
	public void run() {
		lock.lock();
		try {
		while (ticket > 0) {
			try {
				System.out.println(Thread.currentThread().getName() + " 完成售票，余票为：" + --ticket);
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}
		} finally {
			lock.unlock();
			}
		

	}

}
