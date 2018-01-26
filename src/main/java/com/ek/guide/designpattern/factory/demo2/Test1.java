package com.ek.guide.designpattern.factory.demo2;

public class Test1 {
	public static void main(String[] args) {
		Car c1 = new CarAudiFactoryImpl().getCar();
		Car c2 = new CarBydFactoryImpl().getCar();
		
		c1.run();
		c2.run();
	}
}
