package com.ek.guide.thread1.demo1;

public class Thread2 implements Runnable{

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()); // 获得当前线程对象 和他的名字
		}
	}
	
	public static void main(String[] args) {
		Thread2 thread2 = new Thread2();
		new Thread(thread2,"线程1").start();
		new Thread(thread2,"线程2").start();
	}
}