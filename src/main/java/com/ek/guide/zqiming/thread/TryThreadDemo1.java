package com.ek.guide.zqiming.thread;
public class TryThreadDemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TryThreadDemo1 demo1 = new TryThreadDemo1();
		
		MyThread1 myThread1= new MyThread1();
		MyThread1 myThread2= new MyThread1();
		myThread1.setPriority(10);//优先级
		myThread2.setPriority(2);//优先级
		myThread1.start();//设置线程为就绪状态
		myThread2.start();
		
		for(int i=1;i<3;i++){
			System.out.println(demo1.getClass());
		}
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}