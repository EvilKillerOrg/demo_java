package com.ek.guide.designpattern.singleton;
/**
 * 饿汉单例
 * 
 * 要点:
 * 1. 私有化构造器
 * 2. 定义私有静态的单例对象属性= new 本对象
 * 3. 提供一个静态公有方法把new出来的这个对象返回
 *
 * 说明:
 * 1. 类加载的过程是天然的线程安全
 * 2. 类加载器加载这个类的时候就把这个对象new出来了 不存在延时加载(什么叫饿汉:类初始化时立即加载他的静态属性,当然也就没有延时加载的优势)
 * 3. getInstance不需要同步,调用效率就高
 * 天然的线程安全 无延迟加载 调用效率就高(资源利用率低)
 * 
 * @author EK
 * @date 2017年7月26日
 */
public class SingletonDemo1 {
	
	//1. 私有化构造器
	private SingletonDemo1(){
	}
	
	
	//2. 定义私有静态的单例对象属性= new 本对象
	private static SingletonDemo1 s = new SingletonDemo1();
	
	
	//3. 提供一个静态公有方法把new出来的这个对象返回
	public static SingletonDemo1 getInstance(){ 
		return s;
	}
}