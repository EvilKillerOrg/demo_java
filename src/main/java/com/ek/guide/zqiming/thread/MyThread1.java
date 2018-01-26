package com.ek.guide.zqiming.thread;

public class MyThread1 extends Thread{
	
	private int shareInt;
	
	public MyThread1(){
		shareInt = 100;
		System.out.println("调用一次构造函数,创建一个线程对象: "+this.getName());
		
	}
	
	//线程对象处理任务的方法
	public void run(){
		double sum = 0;
		for(int i=0;i<10;i++){
			shareInt = ((int)(3*Math.random()))*shareInt;
			sum+=shareInt;
			try {
				Thread.sleep(5000);//5000毫秒
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("计算中: "+sum+"\t\t"+this.getName());
		}
		
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxx最终计算结果 sum= "+sum+"\t"+"shareInt= "+shareInt+"\n");
	}

}