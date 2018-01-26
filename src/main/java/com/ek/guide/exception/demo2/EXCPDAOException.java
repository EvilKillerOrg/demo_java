package com.ek.guide.exception.demo2;

public class EXCPDAOException extends RuntimeException{
 
	private static final long serialVersionUID = -7480726196673407678L;

	//自定义异常 覆盖Override父类的构造方法
	public EXCPDAOException() {
		super();
	}

	public EXCPDAOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EXCPDAOException(String message, Throwable cause) {
		super(message, cause);
	}

	public EXCPDAOException(String message) {
		super(message);
	}

	public EXCPDAOException(Throwable cause) {
		super(cause);
	}

	
}