package com.ek.guide.designpattern.factory.demo2;

public class CarAudiFactoryImpl implements ICarFactory {

	@Override
	public Car getCar() {
		return new Audi();
	}

}
