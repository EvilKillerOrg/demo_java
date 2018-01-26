package com.ek.guide.thread1.demo3;
/**
 * 阻塞状态
 * 1.join 合并线程(合并成一个线程 从上到下顺序执行 是一个成员方法)
 */
public class Test2 extends Thread{
	
	public static void main(String[] args) throws InterruptedException {
		Test2 test = new Test2();
		Thread thread = new Thread(test); //新生
		thread.start(); //就绪
		// CPU调度到了就运行
		
		for(int i=0; i<10; i++){
			if(5==i){
				thread.join(); //main阻塞...等thread1执行完
			}
			 System.out.println("main....."+i);
		 }
	}
	
	@Override
	public void run() {
	 for(int i=0; i<10; i++){
		 System.out.println("thread1....."+i);
	 }
	}

}