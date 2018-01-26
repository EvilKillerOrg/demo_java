package com.ek.guide.designpattern.singleton;
/**
 * 测试 各种单例模式 创建是否都只有一个实例
 * @author EK
 * @date 2017年7月27日
 */
public class Test1 {
	
	public static void main(String[] args){
		
		test1();
		test2();
		test3();
	}
	
	
	
	//饿汉单例
	public static void test1(){
		SingletonDemo1 s1 = SingletonDemo1.getInstance();
		SingletonDemo1 s2 = SingletonDemo1.getInstance();
		
		System.out.println(s1);
		System.out.println(s2+"\n");
	}
	
	//懒汉单例
	public static void test2(){
		SingletonDemo2 s1 = SingletonDemo2.getInstance();
		SingletonDemo2 s2 = SingletonDemo2.getInstance();
		
		System.out.println(s1);
		System.out.println(s2+"\n");
	}
	
	
	//静态内部类单例
	public static void test3(){
		SingletonDemo3 s1 = SingletonDemo3.getInstance();
		SingletonDemo3 s2 = SingletonDemo3.getInstance();
		
		System.out.println(s1);
		System.out.println(s2);
	}

}