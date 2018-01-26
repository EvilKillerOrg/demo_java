package com.ek.guide.designpattern.singleton;
/**
 * 懒汉单例
 * 
 * 要点:
 * 1. 私有化构造器
 * 2. 定义私有静态的单例对象属性 不初始化,延时加载 真正用的时候在创建
 * 3. 提供一个静态同步的公有方法当这个对象的实例不存在时new出这个对象并返回
 * 
 * 说明:
 * 1. getInstance加synchronized使之同步,避免并发高的时候创建多个对象,线程安全
 * 2. 加载类的时候不会有实例,真正用的时候才创建实现了懒惰
 * 3. getInstance加synchronized同步调用效率低
 * 线程安全 有延迟加载 调用效率低(资源利用率高)
 * 
 * @author EK
 * @date 2017年7月26日
 */
public class SingletonDemo2 {
	
	//1. 私有化构造器
	private SingletonDemo2(){
	}
	
	//2. 定义私有静态的单例对象属性 不初始化,延时加载 真正用的时候在创建
	private static SingletonDemo2 s;
	
	
	//3. 提供一个静态同步的公有方法当这个对象的实例不存在时new出这个对象并返回
	public static synchronized SingletonDemo2 getInstance(){
		if(s==null){
			s = new SingletonDemo2();
		}
		return s;
	}

}