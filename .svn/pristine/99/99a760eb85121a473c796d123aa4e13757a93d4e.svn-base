package com.huaao.ejwplatform.common.web;

import com.huaao.ejwplatform.common.Constants;

public class SystemException extends Exception{
	private static final long serialVersionUID = -2179251416206110262L;
	private int errorCode ;
	
	private SystemException(String mesage){
		super(mesage);
	}
	
	public static SystemException init(String message){
		return init(Constants.API_CODE_SERVER_ERROR,message);
	}
	
	public static SystemException init(int errorCode , String message){
		SystemException se = new SystemException(message);
		se.errorCode = errorCode;
		return se;
	}

	public int getErrorCode() {
		return errorCode;
	}
	
}
