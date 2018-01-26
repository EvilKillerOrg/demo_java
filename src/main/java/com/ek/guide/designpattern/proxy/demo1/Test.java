package com.ek.guide.designpattern.proxy.demo1;
/**
 * 静态代理
 * 需要一个接口,即抽象角色
 * 需要一个真实角色,类
 * 需要一个代理角色,类
 * 真实角色和代理角色都要实现同一个抽象角色
 * 代理角色通过构造器来持有一个真实角色的引用
 * 
 * 意义就在于, 真实角色的方法被调用前后,代理角色可以处理一些方法
 * 
 * 静态代理和动态代理的功能是一致的,区别是静态代理需要自己写代理角色,动态代理是在使用的时候动态生成代理类
 * 
 * 比如spring的后置处理器
 * 
 * @author EK
 * @date 2017年8月4日
 */
public class Test {
	
	public static void main(String[] args) {
		IStar realStar = new RealStar();
		IStar proxy = new ProxyStar(realStar); //代理角色通过构造器来持有一个真实角色的引用
		
		proxy.confer(); //代理角色实现的
		proxy.signContract(); //代理角色实现的
		proxy.bookTicket(); //代理角色实现的
		
		proxy.sing(); //在代理角色类中调用真实角色类中的方法 (对于客户(调用者)来说 就是找代理要了个唱歌,代理找周杰伦 客户并不关心)
		
		proxy.collectMoney(); //代理结算实现的
	}

}