package com.ek.guide.thread1.demo4;
/**
 * isAlive() 方法
 * @author EK
 * @date 2017年8月5日
 */
public class Test1 {

	 public static void main(String[] args) throws InterruptedException {
		 MyThread it = new MyThread();
		 Thread proxy = new Thread(it,"挨踢");
		 proxy.setName("test");
		 System.out.println(proxy.getName());
		 System.out.println(Thread.currentThread().getName());
		 
		 proxy.start();
		 System.out.println("启动后的状态:"+proxy.isAlive());
		 
		 
		 Thread.sleep(2);
		 it.stop();
		 Thread.sleep(100);
		 System.out.println("停止后的状态:"+proxy.isAlive());
	}
}