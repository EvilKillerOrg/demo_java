package com.ek.guide.designpattern.factory.demo1;
/**
 * 测试用简单工厂
 * 这里就不需要管实现类具体怎么去创建的 也不用知道实现类是什么
 * @author EK
 * @date 2017年7月27日
 */
public class Test2 {
	
	public static void main(String[] args) {
		Car c1 = CarFactory1.getCar("奥迪");
		Car c2 = CarFactory1.getCar("比亚迪");
		c1.run();
		c2.run();
		
		System.out.println("\n");
		
		Car c3 = CarFactory2.getCar("奥迪");
		Car c4 = CarFactory2.getCar("比亚迪");
		c3.run();
		c4.run();
	}
}