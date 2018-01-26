package com.ek.guide.designpattern.factory.demo1;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 简单工厂
 * 用map看着高档一些
 * @author EK
 * @date 2017年7月27日
 */

public class CarFactory2 {
	
	private static Map<String , Object> carMap = new HashMap<String , Object>();
	
	static{
		carMap.put("奥迪", new Audi());
		carMap.put("比亚迪", new Byd());
	}
	
	public static Car getCar(String type){
		return (Car) carMap.get(type);
	}
	
}