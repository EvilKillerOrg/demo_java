package com.ek.guide.thread1.demo2;

/**
 * 实现Runnable的方式创建线程
 * 多一个例子 共享资源 50张票(真实角色) 多个黄牛(多个代理角色(线程))
 */
public class Test3 implements Runnable {

	private int num = 50; // 有50张票

	@Override
	public void run() {

		while (true) {
		
			if (num <= 0) {
				System.out.println("黄牛把票搞光了");
				//跳出循环
				//break 和return 都会出问题
				break; 
			}
			try {
				Thread.sleep(500); //延迟一下 但是这里延迟容易出问题
				//甲乙丙在num=1的时候都能进来分别拿走 1 0 -1 三个数
				//还有多个黄牛那同一张票的问题 这就是并发的问题 就是说资源不同步 没有加锁 线程不安全 没处理并发
				//com.ek.guide.thread.demo5.Test1 重写了一个线程安全的
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "抢到了" + num--);
		}
		
	}
	
	
	public static void main(String[] args) {
		Test3 piao = new Test3();//真实角色
		Thread t1 = new Thread(piao,"黄牛甲");
		Thread t2 = new Thread(piao,"黄牛乙");
		Thread t3 = new Thread(piao,"黄牛丙");
		
		t1.start();
		t2.start();
		t3.start();
	}

}