package com.ek.guide.zqiming.chapter2;

public class ForLoopDemo2 {

	public static void main(String[] args) {
		int sum = 0;
		int i=1;
		for(;i<=100;){
			sum=sum+i;
			i++;
		}
		System.out.println("sum= "+sum);
		System.out.println("i= "+i);
	}
}