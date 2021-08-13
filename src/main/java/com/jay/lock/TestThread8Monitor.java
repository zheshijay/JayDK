package com.jay.lock;

/*
 * 题目：判断打印的 one or two
 * 
 * 1. 两个普通的的同步方法，两个线程，标准打印: One Two
 * 2. 新增Thread.sleep(3000) 给 getOne，打印: One Two
 * 3. 新增普通方法getThree（）：Three one two
 * 4. 两个普通同步方法，两个number，
 * 5. 修改getOne（）为静态方法，打印：
 * 6. 两个方法均为静态同步方法，一个number对象，打印：one two
 * 7. 是一个是静态同步方法，一个是非静态方法  打印：two one
 * 8. 两个静态同步方法 两个number： One Two
 * 
 * 
 * 线程8锁的关键：
 * 
 * 1. 非静态方法的锁默认为 this，静态方法的锁为 对应的Class实例
 * 2. 某一个时刻内，只能有一个线程持有锁，无论几个方法。
 */

public class TestThread8Monitor {

	public static void main(String[] args) {

		final Number number1 = new Number();
		final Number number2 = new Number();

		new Thread(new Runnable() {
			@Override
			public void run() {
				number1.getOne();
			}

		}, "A").start();

		new Thread(new Runnable() {
			@Override
			public void run() {
//				number1.getTwo();
				number2.getTwo();
			}

		}, "B").start();
		
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				number1.getThree();
//			}
//
//		}, "C").start();

	}

}

class Number {

	public static synchronized void getOne() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("One");
	}

	public static synchronized void getTwo() {
		System.out.println("Two");
	}
	
	public synchronized void getThree() {
		System.out.println("Three");
	}
}
