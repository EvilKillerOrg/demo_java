package com.ek.guide.zqiming.designpattern.factory.mode3;

import com.ek.guide.zqiming.designpattern.factory.vo.UserInfoVO;

public class Main {

	public static void main(String[] args) {
		InstanceFactory instFactory = new InstanceFactory();
		UserInfoVO user = instFactory.getBean("mike");
		System.out.println(user.getUsername());
	}
}
