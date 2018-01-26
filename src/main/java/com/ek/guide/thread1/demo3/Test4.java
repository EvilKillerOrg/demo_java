package com.ek.guide.thread1.demo3;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 阻塞状态
 * 3.sleep 暂停线程(指定时间间隔执行 , 休眠的时候不释放锁)
 * 用在与时间相关的时候: 比如倒计时 , 模拟网络延时
 */
public class Test4 {
	public static void main(String[] args) throws InterruptedException {
		
		test1();
		test2();
		
	}
	
	
	
	/*倒计时1*/
	public static void test1() throws InterruptedException{
		int num = 10;
		while(true){
			System.out.println(Thread.currentThread().getName()+"Thread---"+num--);
			Thread.sleep(1000); //暂停一秒
			if(num<=0){
				break;
			}
		}
	}
	
	
	/*倒计时2*/
	public static void test2() throws InterruptedException{
		Date endTime = new Date(System.currentTimeMillis()+10*1000);
		long end = endTime.getTime();
		while(true){
			//输出
			System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
			//等待一秒
			Thread.sleep(1000);
			//构建下一秒的时间
			endTime = new Date(endTime.getTime()-1000);
			// 在10秒以内就继续 , 否则break
			if(end-10000>endTime.getTime()){
				break;
			}
		}
	}
	
	
	/*网络延时*/
	public static void test3(){
		// 看这个  com.ek.guide.thread.demo2.Test3 	
		//甲乙丙在num=1的时候都能进来分别拿走 1 0 -1 三个数
		//还有多个黄牛那同一张票的问题 这就是并发的问题 就是说资源不同步 没有加锁 线程不安全 没处理并发
		// com.ek.guide.thread.demo5.Test1 重写了一个线程安全的
	}
}