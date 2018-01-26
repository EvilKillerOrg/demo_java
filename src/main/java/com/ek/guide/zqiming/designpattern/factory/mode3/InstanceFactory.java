package com.ek.guide.zqiming.designpattern.factory.mode3;

import java.util.HashMap;
import java.util.Map;

import com.ek.guide.zqiming.designpattern.factory.vo.UserInfoVO;

public class InstanceFactory {
	private Map<String,UserInfoVO> userMap = null;
	
	
	public InstanceFactory(){
		userMap = new HashMap<String,UserInfoVO>();
		userMap.put("ek", new UserInfoVO("ek","123"));
		userMap.put("mike", new UserInfoVO("mike","456"));
		userMap.put("robin", new UserInfoVO("ek","789"));
	}
	
	
	public UserInfoVO getBean(String name){
		return userMap.get(name);
	}
}
