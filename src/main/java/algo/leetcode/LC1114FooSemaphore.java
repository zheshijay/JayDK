package algo.leetcode;

import java.util.concurrent.Semaphore;

public class LC1114FooSemaphore {
	Semaphore semaphore12, semaphore23;

	public LC1114FooSemaphore() {
		// 初始的允许请求均设为0
		semaphore12 = new Semaphore(0);
		semaphore23 = new Semaphore(0);
	}

	public void first(Runnable printFirst) throws InterruptedException {
		// printFirst.run() outputs "first". Do not change or remove this line.
		printFirst.run();
		// 释放一个12的信号量
		semaphore12.release();
	}

	public void second(Runnable printSecond) throws InterruptedException {
		// 获取一个12的信号量，没有则阻塞
		semaphore12.acquire();
		// printSecond.run() outputs "second". Do not change or remove this line.
		printSecond.run();
		// 释放一个23的信号量
		semaphore23.release();
	}

	public void third(Runnable printThird) throws InterruptedException {
		// 获取一个23的信号量，没有则阻塞
		semaphore23.acquire();
		// printThird.run() outputs "third". Do not change or remove this line.
		printThird.run();
	}

	public static void main(String[] args) {
		LC1114FooSemaphore foo = new LC1114FooSemaphore();
		Runnable printFirst = new Runnable() {
			@Override
			public void run() {
				System.out.println("Running first");
			}
		};

		Runnable printSecond = new Runnable() {
			@Override
			public void run() {
				System.out.println("Running second");
			}
		};

		Runnable printThird = new Runnable() {
			@Override
			public void run() {
				System.out.println("Running third");
			}
		};

		// *******************************************************************************************
		
		System.out.println("trigger printThird");
		Thread thread3 = new Thread() {
			public void run() {
				try {
					foo.third(printThird);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		thread3.start();


		System.out.println("trigger printSecond");
		Thread thread2 = new Thread() {
			public void run() {
				try {
					foo.second(printSecond);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		thread2.start();
		

		System.out.println("trigger printFirst");
		Thread thread1 = new Thread() {
			public void run() {
				try {
					foo.first(printFirst);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		thread1.start();

		
	}
}
