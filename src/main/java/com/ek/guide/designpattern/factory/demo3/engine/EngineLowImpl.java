package com.ek.guide.designpattern.factory.demo3.engine;
// 低端发动机实现类
public class EngineLowImpl implements IEngine{

	@Override
	public void run() {
		System.out.println("跑得慢");
	}

	@Override
	public void start() {
		System.out.println("启动慢");
	}

}