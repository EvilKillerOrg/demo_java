package com.ek.guide.designpattern.factory.demo3.engine;
// 高端发动机实现类
public class EngineLuxuryImpl implements IEngine{

	@Override
	public void run() {
		System.out.println("跑得快");
	}

	@Override
	public void start() {
		System.out.println("启动快");
	}

}