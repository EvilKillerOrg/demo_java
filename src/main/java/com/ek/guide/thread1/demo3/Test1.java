package com.ek.guide.thread1.demo3;

/**
 * 线程状态: 
 * 1. 新建状态(New) 
 * 2. 就绪状态(Runnable) 
 * 3. 运行状态(Running) 
 * 4. 阻塞状态(Blocked) 
 * 5. 死亡状态(Dead)
 */

/**
 * 如何终止一个线程
 * 1. 自然终止 运行结束
 * 2. 外部干涉
 */
public class Test1 {
	public static void main(String[] args) {
		Study s = new Study();
		new Thread(s).start();
		
		//外部干涉
		for(int i=0; i<10; i++){
			if(5==i){
				s.stop();
			}
			System.out.println("main.....--->"+i);
		}
	}
}



class Study implements Runnable {

	private boolean flag = true; // 1.在线程类定义线程体中使用的标识

	@Override
	public void run() {
		// 2.在线程体中使用该标识
		while (flag) {
			System.out.println("study thread.....");
		}
	}

	// 3. 对外提供方法改变标识
	public void stop() {
		this.flag = false;
	}
}