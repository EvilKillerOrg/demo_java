package com.ek.guide.thread1.demo2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 实现Callable的方式创建线程
 * 
 * 这种方式比较繁琐 但是比run方法好的是 可以返回值 可以向外抛出异常
 */
public class Test4 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService ser = Executors.newFixedThreadPool(2); //创建2个线程
		
		Bar gui = new Bar("王八" , 1000);
		Bar tu = new Bar("兔砸" , 500);
		
		Future<Integer> result1 =  ser.submit(gui); //获得返回的值
		Future<Integer> result2 =  ser.submit(tu); //获得返回的值
		
		Thread.sleep(2000); //2秒
		gui.setFlag(false); //停止线程体循环
		tu.setFlag(false); //停止线程体循环
		
		int num1 = result1.get();
		int num2 = result2.get();
		System.out.println("乌龟跑了--->"+num1+"步");
		System.out.println("兔子跑了--->"+num2+"步");
		ser.shutdown(); //停止服务(线程)
	}
}




class Bar implements Callable<Integer>{ //实现这个接口要给<>中写call方法返回值的类型
	private String name; //名称
	private long time; //延时的时间
	private int step = 0; //步数
	private boolean flag = true;
	
	public Bar() {
	}
	public Bar(String name , long time) {
		this.name = name;
		this.time = time;
	}
	

	
	//线程体
	@Override 
	public Integer call() throws Exception {
		while(flag){
			Thread.sleep(time); //延时
			step++;
		}
		return step;
	}

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}