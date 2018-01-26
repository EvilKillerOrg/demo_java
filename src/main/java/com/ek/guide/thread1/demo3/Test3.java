package com.ek.guide.thread1.demo3;
/**
 * 阻塞状态
 * 2.yield 暂停线程(暂停自己 让出CPU调度 高风亮节 是一个static方法)
 */
public class Test3 extends Thread{
	public static void main(String[] args) throws InterruptedException {
		Test3 test = new Test3();
		Thread thread = new Thread(test); //新生
		thread.start(); //就绪
		// CPU调度到了就运行
		
		for(int i=0; i<100; i++){
			if(i%2==0){
				Thread.yield(); // 暂停本线程 让出CPU调度(写在谁的线程体里就暂停谁 , 写在main就是暂停main)
			}
			 System.out.println("main....."+i);
		 }
	}
	
	@Override
	public void run() {
	 for(int i=0; i<100; i++){
		 System.out.println("thread1....."+i);
	 }
	}
}