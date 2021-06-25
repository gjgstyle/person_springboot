package com.pratice.eurekaclient.Entity;

import lombok.Data;

@Data
public class ResponseBodyEntity<T> {
	/**
	 * 响应状态code
	 */
	private String state;
	/**
	 * 响应信息
	 */
	private String message;
	/**
	 * data
	 */
	private T result;

	public void setResponseInfo(String state,String message,T result){
		this.state = state;
		this.message= message;
		this.result = result;
	}


}
