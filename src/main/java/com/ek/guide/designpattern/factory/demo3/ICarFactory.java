package com.ek.guide.designpattern.factory.demo3;

import com.ek.guide.designpattern.factory.demo3.engine.IEngine;
import com.ek.guide.designpattern.factory.demo3.seat.ISeat;
import com.ek.guide.designpattern.factory.demo3.tyre.ITyre;

public interface ICarFactory {
	IEngine getEngine();
	ISeat getSeat();
	ITyre getTyre();

}
