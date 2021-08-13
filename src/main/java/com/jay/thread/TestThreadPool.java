package com.jay.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
 * 1. 线程池：提供了一个线程队列，队列中保存着有等待状态的线程。避免了创建和销毁线程的额外性能开销，提高了相应速度。
 * 
 * 2. 线程池的体系结构：
 * java.util.concurrent.Executor: 负责线程的使用与调度的根接口
 *     |-- ExecutorService 子接口：线程池的主要接口  （主要使用的接口）
 *        |-- ThreadPoolExecutor： 实现类
 *        |-- ScheduledExecutorService: 子接口：负责线程的调度
 *            |-- ScheduledThreadPoolExecutor : 集成ThreadPoolExecutor 实现ScheduledExecutorService
 *            
 *            
 * 3. 工具类： Executors
 * ExecutorService.newFIxedTHreadPool() ： 创建固定大小的线程池
 * ExecutorService.newCachedThreadPool(): 线程池大小不固定，根据需求自动分配
 * Executors.newSingleThreadExecutor(): 单个线程池，池子中只有一个线程
 * Executors.newScheduledThreadPool(): 创建固定大小的线程，可以延迟或者定时的执行任务
 * 
 */
public class TestThreadPool {
	
	private void testScheduledThreadPool() throws Exception {
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);
		
		for(int i=0;i<5;i++) {
			Future<Integer> future = pool.schedule(new Callable() {

				@Override
				public Object call() throws Exception {
					int num = new Random().nextInt(100); // 生成随机数
					System.out.println(Thread.currentThread().getName() + " : " + num);
					return num;
				}
				
			}, 3, TimeUnit.SECONDS);
			
			System.out.println("result:" + future.get());
		}
		
		pool.shutdown();
		
	}

	private void testCallable() {

		// 1. 创建线程池
		ExecutorService pool = Executors.newFixedThreadPool(5);

		List<Future<Integer>> futures = new ArrayList<>();

		for (int i = 0; i < 10; i++) {

			Future<Integer> future = pool.submit(new Callable<Integer>() {

				@Override
				public Integer call() throws Exception {
					// TODO Auto-generated method stub
					int sum = 0;

					for (int i = 0; i <= 100; i++) {
						sum += i;
					}
					return sum;
				}

			});
			
			futures.add(future);
		}

		// 2. 为线程池中的线程分配任务

		for(Future future: futures) {
			try {
				System.out.println(Thread.currentThread().getName() + " - " + future.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// 3. 关闭线程池
		pool.shutdown();

	}
	
	private void testNormalPool () {
		ThreadPoolDemo tpd = new ThreadPoolDemo();
		
		// 1. 创建线程池
		ExecutorService pool = Executors.newFixedThreadPool(5);

		// 2. 为线程池中的线程分配任务

		for (int i = 0; i <= 10; i++) {
			pool.submit(tpd);
		}

		// 3. 关闭线程池
		pool.shutdown();
	}

	public static void main(String[] args) throws Exception {
		TestThreadPool test = new TestThreadPool();
		test.testScheduledThreadPool();

	
	}

}

class ThreadPoolDemo implements Runnable {
	private int i = 0;

	@Override
	public void run() {

		while (i <= 100) {
			System.out.println(Thread.currentThread().getName() + " : " + i++);

		}

	}

}
