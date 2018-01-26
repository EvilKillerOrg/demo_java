package com.ek.guide.zqiming.chapter6;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class Person  implements Serializable{ //Serializable这个接口特殊 不用去覆盖这个接口中的方法
	private String name;
	
	
	public Person(){
		
	}
	
	public Person(String name){
		this.name=name;
	}
	
	public String toString(){
		return this.name+"\n";
	}
	
	public abstract String getDescription();
	
}