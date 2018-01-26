package com.ek.guide.thread1.demo6;

/**
 * 一个线程 消费者
 * 
 * @author EK
 * @date 2017年8月6日
 */
public class Watcher implements Runnable {
	private Movie m;

	public Watcher(Movie m) {
		this.m = m;
	}

	@Override
	public void run() {
		for(int i=0; i<20; i++){
			try {
				m.watch();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}