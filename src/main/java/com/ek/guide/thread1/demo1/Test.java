package com.ek.guide.thread1.demo1;

/**
 * 传统创建线程的两种方式
 * (这里面都是匿名内部类动态实现 看着不清楚 我把他改成继承关系 放在了demo1包中的Thread1和Thread2看的清楚)
 * @author EK
 * @date 2017年8月1日
 * (demo1是马士兵讲的 感觉不是很好 然后看的是张孝祥的)
 */
public class Test {
	public static void main(String[] args) {
		
		// 方式一 new Thread的子类
		Thread thread1 = new Thread() {
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
		};
		thread1.start(); //启动该线程。

		
		
		// 方式一 new Runnable 更加体现面向对象的方式
		Thread thread2 = new Thread(new Runnable() {
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
		});
		thread2.start(); //启动该线程。
	}

}