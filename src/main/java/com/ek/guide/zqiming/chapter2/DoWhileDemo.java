package com.ek.guide.zqiming.chapter2;

public class DoWhileDemo {

	public static void main(String[] args) {
		double sum =0;
		int i = 1000;
		
		//do while 先执行循环体,再进行条件判断
		//while 先判断条件,在执行循环体
		do{
			sum=sum+i;
			i++;
		}while(i<=100);
		
		
		System.out.println("sum= "+sum);
		System.out.println("退出时i= "+i);
	}

}