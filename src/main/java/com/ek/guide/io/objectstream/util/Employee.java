package com.ek.guide.io.objectstream.util;

public class Employee implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String empName;
	private String age;

	public Employee(String empName, String age) {
		this.empName = empName;
		this.age = age;
	}

	@Override
	public String toString() {

		return super.toString() + "\n empName: " + empName + " age: " + age;
	}

}