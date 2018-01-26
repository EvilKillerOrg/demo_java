package com.ek.guide.thread1.demo1;

public class Thread1 extends Thread{

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
		new Thread1().start();
		new Thread1().start();
	}
}