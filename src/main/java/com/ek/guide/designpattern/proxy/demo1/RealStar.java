package com.ek.guide.designpattern.proxy.demo1;
/**
 * 真实角色
 */
public class RealStar implements IStar{

	@Override
	public void confer() {
		System.out.println("真实角色: RealStar.confer()");
	}

	@Override
	public void signContract() {
		System.out.println("真实角色: RealStar.signContract()");
	}

	@Override
	public void bookTicket() {
		System.out.println("真实角色: RealStar.bookTicket()");
	}

	@Override
	public void sing() {
		System.out.println("真实角色: RealStar.sing(周杰伦)");
	}

	@Override
	public void collectMoney() {
		System.out.println("真实角色: RealStar.collectMoney()");
	}

}