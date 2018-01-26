package com.ek.guide.designpattern.factory.demo2;

public class CarBydFactoryImpl implements ICarFactory {

	@Override
	public Car getCar() {
		return new Byd();
	}

}
