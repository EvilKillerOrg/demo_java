package com.ek.guide.designpattern.singleton;
/**
 * 枚举实现单例(枚举类天然就是单例的,最简单,最好用.通过JVM内部机制保证 
 * 可以避免通过反射和反序列化的漏洞,调用效率高 , 缺点是不能延时加载)
 * 
 * @author EK
 * @date 2017年7月26日
 */
public enum SingletonDemo4 {
	
	INSTANCE; //用SingletonDemo4.INSTANCE 就能得到这个 枚举本身就是单例的
	
	//添加自己需要的操作
	public void singletonOperation(){
		
	}
}