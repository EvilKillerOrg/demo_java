package com.ek.guide.thread1.demo4;
/**
 * 优先权 代表的是概率 不代表绝对的先后顺序 默认是5
 * MAX_PRIORITY 10
 * NORM_PRIORITY 5
 * MIN_PRIORITY 1
 * @author EK
 * @date 2017年8月5日
 */
public class Test2 {
	public static void main(String[] args) throws InterruptedException {
		MyThread it1 = new MyThread();
		MyThread it2 = new MyThread();
		
		Thread p1 = new Thread(it1,"挨踢1");
		Thread p2 = new Thread(it2,"挨踢2");
		
		p1.setPriority(Thread.MIN_PRIORITY);
		p1.setPriority(Thread.MAX_PRIORITY);
		
		p1.start();
		p2.start();
		
		Thread.sleep(2);
		
		it1.stop();
		it2.stop();
	}
}