package com.ek.guide.zqiming.chapter2;

public class Testing1 {

	 
	public static void main(String[] args) {
		int i=10;
		int j=20;
		System.out.println("result= "+(i++));
		System.out.println("i= "+i);
		System.out.println("result= "+(++j));
		System.out.println("j= "+j);
		
		int m=10;
		int n=20;
		System.out.println("result= "+(m--));
		System.out.println("m= "+m);
		System.out.println("result= "+(--n));
		System.out.println("n= "+n);
	}

}