package com.jay.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable {
	
	/*
	 * 1. 创建执行线程的方式三：实现Callable 接口。相较于
	 * 
	 * 
	 * 
	 */

	public static void main(String[] args) {
		
		
		ThreadDemo td = new ThreadDemo();
		
		//1. 执行Callable 方式，需要FutureTask实现类的支持. 
		FutureTask<Integer> result = new FutureTask<>(td);
		new Thread(result).start();
		
		//2. 接收线程运算后的结果
		
		try {
			System.out.println("------------------------------------------------------------------"); // 如果所有的new Thread(result).start();所有的线程没有结束，这一条执行不会执行，所以FutureTask也可以用于闭锁。
			System.out.println("result:" + result.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
	
	class ThreadDemo implements Callable<Integer> {

		@Override
		public Integer call() throws Exception {
			int sum = 0;
			
			for (int i=0; i<=1000000; i++) {
				System.out.println("i:" + i);
				sum +=i;
			}
			return sum;
		}
		
	}
