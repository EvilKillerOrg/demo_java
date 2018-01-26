package com.ek.guide.designpattern.singleton;
/**
 * 静态内部类实现单例(也是一种懒惰加载)
 * 
 * 要点:
 * 1. 私有化构造器
 * 2. 静态内部类中定义单例对象
 * 3. 提供一个静态公有方法 通过调用静态内部类把单例对象返回
 * 
 * 说明:
 * 1. 类加载的过程是天然的线程安全
 * 2. 当第一次实例化这个类的时候 不会立即初始化他的静态内部类 调用SingletonDemo3才加载内部类,从而创建实例 实现了延迟加载
 * 3. static final常量是只读 就不存在同步的问题 加载效率也就好了 (不加final也可以)
 * 线程安全 有延迟加载 调用效率高(基本同时具备3点 用的比较多)
 * 
 * @author EK
 * @date 2017年7月26日
 */
public class SingletonDemo3 {
	
	// 1. 私有化构造器
	private SingletonDemo3(){
		
	}
	
	//2. 静态内部类中定义单例对象
	private static class SingletonClassInstence{
		private static final SingletonDemo3 instence = new SingletonDemo3();
	}
	
	//3. 提供一个静态公有方法 通过调用静态内部类把单例对象返回
	public static SingletonDemo3 getInstance(){
		return SingletonClassInstence.instence;
	}

}