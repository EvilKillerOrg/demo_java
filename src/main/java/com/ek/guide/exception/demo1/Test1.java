package com.ek.guide.exception.demo1;

public class Test1 {
	
	public void myTest1() throws MyException{
		
	}
	public static void main(String[] args) {
		try {
			new Test1().myTest1();
		} catch (MyException e) {
			e.printStackTrace();
		}
	}
}
