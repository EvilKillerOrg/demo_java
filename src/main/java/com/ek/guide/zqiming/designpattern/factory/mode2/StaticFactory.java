package com.ek.guide.zqiming.designpattern.factory.mode2;

import java.util.HashMap;
import java.util.Map;

import com.ek.guide.zqiming.designpattern.factory.vo.UserInfoVO;

public class StaticFactory {

	private static Map<String,UserInfoVO> userMap = new HashMap<String,UserInfoVO>();
	
	
	static{
		userMap.put("ek", new UserInfoVO("ek","123"));
		userMap.put("mike", new UserInfoVO("mike","456"));
		userMap.put("robin", new UserInfoVO("ek","789"));
	}
	
	
	public static UserInfoVO getBean(String name){
		return  userMap.get(name);
	}
}
