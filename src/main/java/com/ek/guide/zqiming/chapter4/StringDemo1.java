package com.ek.guide.zqiming.chapter4;

public class StringDemo1 {

	public static void main(String[] args) {
		String str1 = "hello world!";
		String str2 = "hello world!";
		
		//str1 和 str2 和 "hello world!" 这样是创建了3个对象
		//str1 和 str2 这两个对象都指向了  "hello world!"这个匿名对象 
		//或者说
		//这是把一个匿名的字符串对象地址赋给一个命名的字符串对象来引用这个地址
		
		if(str1==str2){
			System.out.println("str1 str2 相同的对象");
		}else{
			System.out.println("str1 str2 不同的对象");
		}
		
		if(str1.equals(str2)){
			System.out.println("str1 str2 相同的对象");
		}else{
			System.out.println("str1 str2 不同的对象");
		}
		
		//散列码近似的可以认为标记了对象在内存中的位置(绝不是内存地址,只是和内存地址有一定的关系)
		System.out.println("str1: "+str1.hashCode());
		System.out.println("str2: "+str2.hashCode());
		
		
		
		System.out.println();
		
		
		
		//str1 和 str3 内存地址不一样
		//用字符串构造函数建立一个字符串对象,这个字符串就在内存中获得了一个新的地址
		String str3 = new String("hello world!");
		
		if(str1==str3){
			System.out.println("str1 str3 相同的对象");
		}else{
			System.out.println("str1 str3 不同的对象");
		}
		
		if(str1.equals(str3)){
			System.out.println("str1 str3 相同的对象");
		}else{
			System.out.println("str1 str3 不同的对象");
		}
		
		System.out.println("str1: "+str1.hashCode());
		System.out.println("str3: "+str3.hashCode());
		
	}

}