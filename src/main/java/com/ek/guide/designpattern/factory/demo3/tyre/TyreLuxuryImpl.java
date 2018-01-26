package com.ek.guide.designpattern.factory.demo3.tyre;

public class TyreLuxuryImpl implements ITyre{

	@Override
	public void revolve() {
		System.out.println("噪音小");
	}

}