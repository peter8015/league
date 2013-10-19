package com.base.platform.framework.utils;
/**
 * 自定义用户异常类
 * 

 *
 */
@SuppressWarnings("serial")
public class UserException extends RuntimeException {
	private String key = "";

	public UserException(String key, String msg) {
		super(msg);
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public String getMessage() {
		return super.getMessage();
	}

}
