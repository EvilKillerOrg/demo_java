package com.ek.guide.zqiming.chapter6;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Data implements Serializable{
	private int value;
	
	public Data(int init){
		value = init;
	}
	
	/*
	 * 连个对象比较的方法
	 * 首先判断是否为同一类对象,
	 * 再判断对应的属性的值是否相等
	 * 
	 * 这里比较的是对象中对应的属性的值
	 * 不能比较对象的地址.
	 */
	 
	public boolean equals(Object obj){
		if(obj instanceof Data && ((Data)obj).value==value)
			return true;
		return false;
	}
	
	
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	
}