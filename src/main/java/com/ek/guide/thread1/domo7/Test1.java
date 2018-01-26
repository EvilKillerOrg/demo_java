package com.ek.guide.thread1.domo7;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 任务调度
 * 定时器 java.util.Timer
 * java.util.TimerTask 实现了 Runnable
 * 指定时间执行指定任务
 * 可以去自学quartz任务调度框架 还有JUC真正的线程好用的
 */
public class Test1 {
	
	public static void main(String[] args) {
		Timer timer = new Timer();
		
		// timer.schedule(task, firstTime, period);
		// 参数: task=TimerTask-抽象类动态实现run(), firstTime=什么时候来说运行, period=隔多久再次运行(周期)
		// 不要第3个参数的schedule() 只执行一次
		
		timer.schedule(new TimerTask(){
			@Override
			public void run() {
				System.out.println("so easy.....");
			}}, new Date(System.currentTimeMillis()+1000),2000);
	}
	
}