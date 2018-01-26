package com.ek.guide.zqiming.thread;
public class TryThreadDemo2{
	
	public static void main(String[] args){
		MyThread2 t1 = new MyThread2();
		MyThread2 t2 = new MyThread2();
		MyThread2 t3 = new MyThread2();
		
		Thread thread1 = new Thread(t1);
		Thread thread2 = new Thread(t2);
		Thread thread3 = new Thread(t3);
		
		thread1.start();
		thread2.start();
		thread3.start();
	}
}
