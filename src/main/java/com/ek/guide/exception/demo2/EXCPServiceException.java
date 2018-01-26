package com.ek.guide.exception.demo2;

public class EXCPServiceException extends RuntimeException{

	private static final long serialVersionUID = 8321161777439199170L;

	public EXCPServiceException() {
		super();
	}

	public EXCPServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EXCPServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public EXCPServiceException(String message) {
		super(message);
	}

	public EXCPServiceException(Throwable cause) {
		super(cause);
	}
}
