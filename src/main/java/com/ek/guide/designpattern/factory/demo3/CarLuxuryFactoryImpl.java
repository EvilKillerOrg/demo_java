package com.ek.guide.designpattern.factory.demo3;

import com.ek.guide.designpattern.factory.demo3.engine.EngineLuxuryImpl;
import com.ek.guide.designpattern.factory.demo3.engine.IEngine;
import com.ek.guide.designpattern.factory.demo3.seat.ISeat;
import com.ek.guide.designpattern.factory.demo3.seat.SeatLuxuryImpl;
import com.ek.guide.designpattern.factory.demo3.tyre.ITyre;
import com.ek.guide.designpattern.factory.demo3.tyre.TyreLuxuryImpl;
//高端汽车工厂
public class CarLuxuryFactoryImpl implements ICarFactory{

	@Override
	public IEngine getEngine() {
		return new EngineLuxuryImpl();
	}

	@Override
	public ISeat getSeat() {
		return new SeatLuxuryImpl();
	}

	@Override
	public ITyre getTyre() {
		return new TyreLuxuryImpl();
	}

 

}