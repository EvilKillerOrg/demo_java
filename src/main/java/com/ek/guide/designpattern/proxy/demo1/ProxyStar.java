package com.ek.guide.designpattern.proxy.demo1;
/**
 * 代理角色
 */
public class ProxyStar implements IStar {
	private IStar realStar;
	
	// 构造方法把真实对象传进来 持有一个真实角色的引用
	public ProxyStar(IStar realStar) {
		this.realStar = realStar;
	}

	@Override
	public void confer() {
		System.out.println("代理角色: ProxyStar.confer()");
	}

	@Override
	public void signContract() {
		System.out.println("代理角色: ProxyStar.signContract()");
	}

	@Override
	public void bookTicket() {
		System.out.println("代理角色: ProxyStar.bookTicket()");
	}

	@Override
	public void sing() { //代理自己不能唱歌 得调用真实角色来
		realStar.sing();
	}

	@Override
	public void collectMoney() {
		System.out.println("代理角色: ProxyStar.collectMoney()");
	}

}