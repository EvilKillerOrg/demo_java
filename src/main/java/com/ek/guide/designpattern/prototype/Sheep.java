package com.ek.guide.designpattern.prototype;

import java.util.Date;

/**
 * prototype 原型模式(克隆) 
 * 1.要实现Cloneable 接口(是个标识接口 )
 * 
 * @author EK
 * @date 2017年7月28日
 */
public class Sheep implements Cloneable {
	private String sname;
	private Date birthday;
	
	public Sheep() {
		super();
	}

	public Sheep(String sname, Date birthday) {
		super();
		this.sname = sname;
		this.birthday = birthday;
	}

	
	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object obj = super.clone(); // 直接调用object对象的clone();方法.
		return obj;
	}

}