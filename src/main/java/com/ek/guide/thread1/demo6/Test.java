package com.ek.guide.thread1.demo6;
/**
 * 测试类 
 * 多线程对同一个资源访问
 * 生产者消费者模式\信号灯发
 */
public class Test {
	public static void main(String[] args) {
		Movie movie = new Movie(); //资源
		
		Player player = new Player(movie); //线程1
		Watcher watcher = new Watcher(movie); //线程2
		
		new Thread(player).start();
		new Thread(watcher).start();
		
	}
}