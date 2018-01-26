package com.ek.guide.zqiming.chapter2;

public class ForLoopDemo3 {

	public static void main(String[] args) {
		int sum = 0;
		int i=100;
		for(;;){
			 
			sum=sum+i;
			i--;
			 
			if(i==0){
				break;
			}
			
		}
		System.out.println("sum= "+sum);
		System.out.println("i= "+i);
	}
	
}