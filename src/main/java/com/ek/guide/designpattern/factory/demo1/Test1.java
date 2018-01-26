package com.ek.guide.designpattern.factory.demo1;
/**
 * 测试没有用工厂模式的时候
 * 要有接口,有实现,还要去new,要是实现复杂的时候需要传参什么的
 * @author EK
 * @date 2017年7月27日
 */
public class Test1 {
	
	public static void main(String[] args) {
		Car c1 = new Audi();
		Car c2 = new Byd();
		
		c1.run();
		c2.run();
		
	}

}