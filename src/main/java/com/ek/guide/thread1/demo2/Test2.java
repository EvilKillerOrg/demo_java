package com.ek.guide.thread1.demo2;
/**
 * 实现Runnable的方式创建线程
 * 
 * 也就是使用静态代理模式
 * Runnable 就是抽象角色
 * Thread 就是代理角色 Thread已经实现了Runnable接口
 * 自己类里也实现Runnable  就是真实角色
 */

public class Test2 {

public static void main(String[] args) {
		
		T t = new T();
		Thread thread = new Thread(t); //代理角色持有真实角色的引用
		thread.start();
		for(int i=0; i<10; i++){
			System.out.println("这是主线程");
		}
	}
}



class T implements Runnable{
	
	@Override
	public void run() {
		for(int i=0; i<10; i++){
			System.out.println("这是一个线程.");
		}
	}
	
}