package com.ek.guide.zqiming.chapter2;

public class IfElseDemo1 {
	
	public static void main(String[] args) {
		int i=10;
		int j=20;
		if(++i >= --j){
			System.out.println("成立");
		}else{
			System.out.println("不成立");
		}
		
	}

}