package com.ek.guide.zqiming.chapter2;

public class WhileDemo {

	public static void main(String[] args) {
		/*
		while(条件表达式){
			执行循环体
		}
		*/
		
		
		double sum =0;
		int i = 1;
		while(i<=100){
			sum=sum+i;
			i++;
		}
		
		
		System.out.println("sum= "+sum);
		System.out.println("退出时i= "+i);
	}

}