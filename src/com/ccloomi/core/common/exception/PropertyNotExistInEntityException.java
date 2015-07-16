package com.ccloomi.core.common.exception;

public class PropertyNotExistInEntityException extends RuntimeException{
	private static final long serialVersionUID = -2878838520379299806L;
	public PropertyNotExistInEntityException(){
		super();
	}
	public PropertyNotExistInEntityException(String message){
		super(message);
	}
	public PropertyNotExistInEntityException(String message,Throwable cause){
		super(message,cause);
	}
	public PropertyNotExistInEntityException(Throwable cause){
		super(cause);
	}
	public PropertyNotExistInEntityException(String message, Throwable cause,boolean enableSuppression,boolean writableStackTrace){
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
