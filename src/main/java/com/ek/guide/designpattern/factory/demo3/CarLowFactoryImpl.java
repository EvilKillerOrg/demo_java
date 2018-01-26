package com.ek.guide.designpattern.factory.demo3;

import com.ek.guide.designpattern.factory.demo3.engine.EngineLowImpl;
import com.ek.guide.designpattern.factory.demo3.engine.IEngine;
import com.ek.guide.designpattern.factory.demo3.seat.ISeat;
import com.ek.guide.designpattern.factory.demo3.seat.SeatLowImpl;
import com.ek.guide.designpattern.factory.demo3.tyre.ITyre;
import com.ek.guide.designpattern.factory.demo3.tyre.TyreLowImpl;
//低端汽车工厂
public class CarLowFactoryImpl implements ICarFactory{

	@Override
	public IEngine getEngine() {
		return new EngineLowImpl();
	}

	@Override
	public ISeat getSeat() {
		return new SeatLowImpl();
	}

	@Override
	public ITyre getTyre() {
		return new TyreLowImpl();
	}

 

}