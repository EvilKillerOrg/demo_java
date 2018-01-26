package com.ek.guide.zqiming.chapter2;

public class Testing2 {

	public static void main(String[] args) {
		int i=10;
		int j=20;
		
		System.out.println("result= "+(i++ + ++j));
		System.out.println("result= "+(--i + --j));
		System.out.println("result= "+ i++ + ++j);
	}
}