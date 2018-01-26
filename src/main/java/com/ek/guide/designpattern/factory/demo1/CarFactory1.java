package com.ek.guide.designpattern.factory.demo1;
/**
 * 1. 简单工厂
 * 这有一个问题就是增加新的品牌的时候需要修改这里的代码 违反了开闭原则
 * 不过修改也就是在这修改一下 还是可以接受的
 * 项目开发中通常还是使用简单工厂
 * @author EK
 * @date 2017年7月27日
 */

public class CarFactory1 {
	public static Car getCar(String type){
		if("奥迪".equals(type)){
			return new Audi();
		}else if("比亚迪".equals(type)){
			return new Byd();
		}else{
			return null;
		}
	}
}


