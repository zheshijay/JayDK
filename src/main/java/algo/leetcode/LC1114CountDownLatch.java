package algo.leetcode;

import java.util.concurrent.CountDownLatch;

public class LC1114CountDownLatch {
	CountDownLatch countDownLatch12, countDownLatch23;

	public LC1114CountDownLatch() {
		countDownLatch12 = new CountDownLatch(1);
		countDownLatch23 = new CountDownLatch(1);
	}

	public void first(Runnable printFirst) throws InterruptedException {

		// printFirst.run() outputs "first". Do not change or remove this line.
		printFirst.run();
		countDownLatch12.countDown();
	}

	public void second(Runnable printSecond) throws InterruptedException {
		// 等待计数器归零再向下执行
		countDownLatch12.await();
		// printSecond.run() outputs "second". Do not change or remove this line.
		printSecond.run();
		countDownLatch23.countDown();
	}

	public void third(Runnable printThird) throws InterruptedException {
		// 等待计数器归零再向下执行
		countDownLatch23.await();
		// printThird.run() outputs "third". Do not change or remove this line.
		printThird.run();
	}
}
