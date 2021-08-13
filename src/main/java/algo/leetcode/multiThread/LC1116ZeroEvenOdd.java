package algo.leetcode.multiThread;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class LC1116ZeroEvenOdd {
	private int n;
	private Semaphore zero = new Semaphore(1);
	private Semaphore even = new Semaphore(0);
	private Semaphore odd = new Semaphore(0);

	public LC1116ZeroEvenOdd(int n) {
		this.n = n;
	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public void zero(IntConsumer printNumber) throws InterruptedException {
		for (int i = 1; i <= n; i++) {
			zero.acquire();
			printNumber.accept(0);
			if (i % 2 == 1) {
				odd.release();
			} else {
				even.release();
			}
		}
	}

	public void even(IntConsumer printNumber) throws InterruptedException {
		for (int i = 2; i <= n; i += 2) {
			even.acquire();
			printNumber.accept(i);
			zero.release();
		}
	}

	public void odd(IntConsumer printNumber) throws InterruptedException {
		for (int i = 1; i <= n; i += 2) {
			odd.acquire();
			printNumber.accept(i);
			zero.release();
		}
	}

	public static void main(String[] args) {
		LC1116ZeroEvenOdd zeroEvenOdd = new LC1116ZeroEvenOdd(9);
		
		new Thread(() -> {
			try {
				zeroEvenOdd.zero(System.out::print);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

		new Thread(() -> {
			try {
				zeroEvenOdd.even(System.out::print);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

		new Thread(() -> {
			try {
				zeroEvenOdd.odd(System.out::print);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		
		
//		IntConsumer ic = a->System.out.println(a);
//		ic.accept(1);
//		ic.accept(2);
//		ic.accept(3);
//		ic.accept(4);
		
	}
}
