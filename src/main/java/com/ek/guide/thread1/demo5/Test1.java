package com.ek.guide.thread1.demo5;
/**
 * 同步:也称为并发(多个线程访问同一个资源)
 * synchronized --> 同步 也就是一个锁的概念 执行效率会降低
 * 1. 同步方法
 * 2. 同步块
 * synchronized(引用变量){}
 * com.ek.guide.thread.demo2.Test3 的代码 就是线程不安全的 这里重写了线程安全的例子
 * @author EK
 * @date 2017年8月5日
 */
public class Test1 implements Runnable{
	private int num =10;
	private boolean flag = true;
	
	public static void main(String[] args) {
		Test1 piao = new Test1();
		Thread t1 = new Thread(piao,"黄牛1");
		Thread t2 = new Thread(piao,"黄牛2");
		Thread t3 = new Thread(piao,"黄牛3");
		
		t1.start();
		t2.start();
		t3.start();
		
		
	}
	
	@Override
	public void run() {
		while(flag){
			//this.test1();
			//this.test2();
			this.test3();
		}
	}
	
	
	
	/*线程安全 锁定正确 -- 同步方法*/
	public synchronized void test1(){
		if(num<=0){
			this.flag = false;
			System.out.println("黄牛把票搞光了");
			return; //这里要return 否则会出现 0 -1 -2的问题
		}
		try {
			Thread.sleep(300); //这里模拟了 网络延迟的存在
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"抢票"+num--);
	}
	
	
	
	/*线程安全 锁定正确 -- 同步块*/
	public  void test2(){
		synchronized(this){ //一般要锁定到对象
			if(num<=0){
				this.flag = false;
				System.out.println("黄牛把票搞光了");
				return;  
			}
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"抢票"+num--);
		}
	}
	
	
	
	/*锁定范围不正确 锁定范围过小 线程不安全*/
	public  void test3(){
		synchronized(this){
			if(num<=0){
				this.flag = false;
				System.out.println("黄牛把票搞光了");
				return;  
			}
		} //锁定到这里
		
			try {
				Thread.sleep(300); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"抢票"+num--);
	}
}