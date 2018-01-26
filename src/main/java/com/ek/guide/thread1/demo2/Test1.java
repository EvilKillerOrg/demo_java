package com.ek.guide.thread1.demo2;

import java.util.Date;

/**
 * 线程工作的基本方法 
 * isAlive() //线程是否还未终止 
 * getPriority() //获取优先级数值 优先级越高的线程获得CPU的时间越多
 * setPriority() //设置优先级数值 
 * getName() //取的线程名字
 * setName() //给线程一个名字
 * currentThread() //去的当前正在运行的线程对象,也就是取的自己本身
 * Thread.sleep() //线程睡眠(毫秒) 
 * join() //线程合并 
 * yield() //让出CPU 暂停当前正在执行的线程对象,并执行其他线程
 * wait() //当前线程进入对象的 wait pool 
 * notify()/notifyAll() //唤醒对象的wait pool中的一个或所有等待线程
 * @author EK
 * @date 2017年8月1日
 */

/**
 * 继承Thread 创建线程
 */
public class Test1 {

	public static void main(String[] args) {
		
		MyThread myThread = new MyThread();
		myThread.start();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		myThread.interrupt(); //一盆凉水泼上去 中断了进程(不建议这样中断进程) 
		//myThread.stop();// 这个一更不建议用 这是直接杀死进程 
		//interrupt 还有处理的机会 stop直接都没机会 比如传输文件没关闭 stop了连关闭的机会都没有
		//最好是让程序可以执行完成 执行完了 run的进程也就结束了 比如 加个boolean flag = true; 为false的时候就执行完了
	}
	
	
	
}

 class MyThread extends Thread {
	@Override
	public void run() {
		//boolean flag = true;
		while(true){
			System.out.println("+++++++++"+new Date()+"++++++++++++");
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				//e.printStackTrace();
				return;
			}
		}
		
	}
}