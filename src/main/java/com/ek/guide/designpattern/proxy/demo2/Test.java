package com.ek.guide.designpattern.proxy.demo2;

import java.lang.reflect.Proxy;
 
/**
 * 动态代理
 * JDK 自带的动态代理
 * - java.lang.reflect.Proxy
 * 作用: 动态生成代理类和对象
 * - java.lang.reflect.InvoctionHandler
 *  可以通过invoke方法实现对真实角色的代理访问
 *  每次通过Proxy生成代理类对象时都要指定对象的处理器对象
 *  
 *  参看一下com.ek.spring.demo9_AOP.ArithmeticCalculatorLoggingProxy
 * @author EK
 * @date 2017年8月4日
 */
public class Test {
	public static void main(String[] args) {
		IStar realStar = new RealStar();
		ProxyStarHandler handler = new ProxyStarHandler(realStar);
		
		// 一个代理类对象 
		IStar proxy = (IStar) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{IStar.class} , handler);
		
		
		//在这调代理类 调用的全都在invoke方法中调真实角色的方法 需要在ProxyStarHandler的invoke方法里处理
		proxy.sing();
		
		 
	}

}