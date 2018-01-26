package com.ek.guide.zqiming.thread;

public class MyThread2 implements Runnable{

	public void run(){
		int shareInt=100;
		double sum = 0;
		for(int i=0;i<10;i++){
			shareInt = ((int)(3*Math.random()))*shareInt;
			sum+=shareInt;
			try {
				Thread.sleep(5000);//5000毫秒
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("计算中: "+sum+"\t\t");
		}
		
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxx最终计算结果 sum= "+sum+"\t"+"shareInt= "+shareInt+"\n");
	}
	
}