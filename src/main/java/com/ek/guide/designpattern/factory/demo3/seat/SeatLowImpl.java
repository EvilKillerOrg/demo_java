package com.ek.guide.designpattern.factory.demo3.seat;

public class SeatLowImpl implements ISeat {

	@Override
	public void massage() {
		System.out.println("不能按摩");
	}

}