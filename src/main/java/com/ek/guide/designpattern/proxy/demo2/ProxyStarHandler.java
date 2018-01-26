package com.ek.guide.designpattern.proxy.demo2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/**
 * 动态代理角色
 */
public class ProxyStarHandler implements InvocationHandler {
	
	private IStar realStar;
	// 通过构造器把真实角色传过来(持有真实角色类的引用)
	public ProxyStarHandler(IStar realStar) {
		super();
		this.realStar = realStar;
	}



	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// invoke方法的参数:
	  // proxy 代理类
		// method 正在调用的方法
		// args 方法的参数
		
		System.out.println("处理之前的");
		
		if(method.getName().equals("sing")){
			System.out.println("###########");
			method.invoke(realStar, args); //激活调用的方法
		}
		
		System.out.println("处理之后的");
		
		return null;
	}

}