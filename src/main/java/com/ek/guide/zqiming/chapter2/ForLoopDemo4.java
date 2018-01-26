package com.ek.guide.zqiming.chapter2;

public class ForLoopDemo4 {

	public static void main(String[] args) {
		for(int i=init(); condition(i); i++, update(i)){
			System.out.println("循环体: "+i);
		}
	}
	
	//循环条件
	private static boolean condition(int i) {
		boolean flag=false;
		if(i<=100){
			flag=true;
		}else{
			flag=false;
		}
		return flag;
	}
	
	
	private static int init() {
		System.out.println("循环变量的初始值为0");
		return 0;
	}

	private static void update(int i) {
		System.out.println("每次循环时, i都发生变化: "+i);
	}

}