package com.ek.guide.exception.demo1;
/**
 * 自定义异常
 * @author EK
 * @date 2017年7月30日
 */
public class MyException extends Exception {

	public MyException() {

	}

	public MyException(String message) {
		
		super(message);
	}
}