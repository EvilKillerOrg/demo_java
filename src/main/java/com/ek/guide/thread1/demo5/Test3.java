package com.ek.guide.thread1.demo5;

/**
 * 过多的同步 容易造成死锁  
 * 这里写了一个死锁的例子
 * 解决的方法 生产者消费者模式(不是设计模式) 型号灯发 看demo6
 */
public class Test3 {
	
	/*两个线程 访问同一个资源*/
	public static void main(String[] args) {
		Object g = new Object();
		Object m = new Object();
		
		Test2_1 test1 = new Test2_1(g , m);
		Test2_2 test2 = new Test2_2(g , m);
		Thread porxy1 = new Thread(test1);
		Thread porxy2 = new Thread(test2);
		porxy1.start();
		porxy2.start();
	}
}




/**
 * 一个线程类
 */
class Test2_1 implements Runnable {
	Object goods;
	Object money;

	public Test2_1(Object goods, Object money) {
		super();
		this.goods = goods;
		this.money = money;
	}

	
	@Override
	public void run() {
		while (true) {
			test1();
		}
	}

	public void test1() {
		synchronized (goods) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (money) {
				
			}
		}
		System.out.println("一手交钱");
	}
}






/**
 * 另一个线程类
 */
class Test2_2 implements Runnable {
	Object goods;
	Object money;
	
	public Test2_2(Object goods, Object money) {
		super();
		this.goods = goods;
		this.money = money;
	}

	@Override
	public void run() {
		while (true) {
			test1();
		}
	}

	public void test1() {
		synchronized (money) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (goods) {
				
			}
		}
		System.out.println("一手给货");
	}
}