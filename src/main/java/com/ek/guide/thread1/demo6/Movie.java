package com.ek.guide.thread1.demo6;
/**
 *  生产者消费者模式(不是设计模式) 信号灯发
 *  
 *  wait() 等待,会释放锁 sleep不释放锁 
 *  notify()/notifyAll() 唤醒
 *  
 *  wait() , notify()/notifyAll() 必须要和 synchronized 一起使用 否则不起作用等待不了
 *  
 *  wait() , notify()/notifyAll() 都是 Class Object 里的方法
 */

/**
 * 一个场景 (共同的资源)
 */
public class Movie {
	private String pic;
	private boolean flag = true;
	// flag是信号灯 
	// 为true表示: 生产者生产, 消费者等待, 生产完成后通知消费
	// 为false表示: 消费者消费, 生产者等待, 消费完成后通知生产
	
	
	/* 播放 */
	public synchronized void play(String pic) throws InterruptedException {
		
		if(!flag){ //flag为false时 生产者等待
			this.wait();//等待
		}
		
		//开始生产
		Thread.sleep(500);//生产了500毫秒
		System.out.println("生产了"+pic);
		this.pic = pic; //生产完毕
		//通知消费
		this.notify();
		//生产者停下
		this.flag = false; //flag为false 生产者等待 走wait();
 	}

	
	
	/* 查看 */
	public synchronized void watch() throws InterruptedException {
	
		if(flag){ //flag为true 消费者等待
			this.wait();
		}
		
		//开始消费
		Thread.sleep(200);//消费了200毫秒
		System.out.println("消费了"+pic);//消费完毕
		//通知生产
		this.notify();
		//消费者停下
		this.flag = true;
		
	}

}