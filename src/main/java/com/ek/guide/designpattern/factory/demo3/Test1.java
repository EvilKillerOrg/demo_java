package com.ek.guide.designpattern.factory.demo3;

import com.ek.guide.designpattern.factory.demo3.engine.IEngine;
import com.ek.guide.designpattern.factory.demo3.seat.ISeat;
import com.ek.guide.designpattern.factory.demo3.tyre.ITyre;
//创建一个 好车
public class Test1 {
	public static void main(String[] args) {
		getLuxuryCar();
		getLowCar();
	}
		
	
	
	
	public static void getLuxuryCar(){
		ICarFactory factory = new CarLuxuryFactoryImpl();
		System.out.println("创建一个高档车...");
		
		IEngine engine = factory.getEngine();
		engine.run();
		engine.start();
		
		ISeat seat = factory.getSeat();
		seat.massage();
		
		ITyre tyre = factory.getTyre();
		tyre.revolve();
		
	}
	
	
	
	public static void getLowCar(){
		ICarFactory factory = new CarLowFactoryImpl();
		System.out.println("创建一个低档车...");
		
		IEngine engine = factory.getEngine();
		engine.run();
		engine.start();
		
		ISeat seat = factory.getSeat();
		seat.massage();
		
		ITyre tyre = factory.getTyre();
		tyre.revolve();
		
	}
}