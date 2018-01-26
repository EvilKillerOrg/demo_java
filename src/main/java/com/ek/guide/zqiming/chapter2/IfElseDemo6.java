package com.ek.guide.zqiming.chapter2;

public class IfElseDemo6 {

	
	/*
	每个字符有一个对应的整数,
	java采用Unicode字符集
	C/C++采用ASCII字符集
	Unicode和ASCII用来表示前128个字符时 , 每个字符都与一个整数存在对应管理
	*/
	public static void main(String[] args) {
//		int value=1+(int)(128*Math.random());
//		System.out.println(value);
//		System.out.println((char)value);
		
		char ch = (char)(128*Math.random());
		if(ch>='A'&&ch<='Z'){
			System.out.println("得到一个大写字母: "+ch);
		}else if(ch>='a'&&ch<='z'){
			System.out.println("得到一个小写字母: "+ch);
		}else if(ch>='0'&&ch<='9'){
			System.out.println("得到一个数字: "+ch);
		}else{
			System.out.println("不是字母也不是数字: "+ch);
		}
	}
}