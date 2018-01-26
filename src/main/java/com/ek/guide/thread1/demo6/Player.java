package com.ek.guide.thread1.demo6;

/**
 * 一个线程 生产者
 * 
 * @author EK
 * @date 2017年8月6日
 */
public class Player implements Runnable {
	private Movie m;

	public Player(Movie m) {
		this.m = m;
	}

	@Override
	public void run() {
		for(int i=0; i<20; i++){
			if(0==i%2){
				try {
					m.play("左青龙");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else{
				try {
					m.play("右白虎");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}