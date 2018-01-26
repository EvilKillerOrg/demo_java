package com.ek.guide.zqiming.designpattern.factory.mode2;

import com.ek.guide.zqiming.designpattern.factory.vo.UserInfoVO;

public class Main {

	public static void main(String[] args) {
		UserInfoVO user = StaticFactory.getBean("ek");
		System.out.println(user.getUsername());
	}

}
