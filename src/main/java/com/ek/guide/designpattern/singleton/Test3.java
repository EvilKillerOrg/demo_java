package com.ek.guide.designpattern.singleton;

import java.util.concurrent.CountDownLatch;

/**
 * 测试多线程环境下 各种单例模式的 调用效率
 * 
 * @author EK
 * @date 2017年7月27日
 */
public class Test3 {

	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		int threadNum = 10;
		CountDownLatch countDownLatch = new CountDownLatch(threadNum); //线程计数器 让main方法的线程等待,直到变成0为止等待10个线程都执行完 
		
		for (int i = 0; i < 10; i++) { // 开是个线程
			new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < 100000; i++) {
						Object obj = SingletonDemo1.getInstance();// 一个线程里调用100000次
					}
					countDownLatch.countDown();//执行一次减一
				}
			}).start();
		}
		
		countDownLatch.await();// 主线程在这等待(阻塞) 直到计数器为0 才会往下执行
		long end = System.currentTimeMillis();
		System.out.println("所用时间: " + (end-start));
	}

}