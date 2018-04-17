package com.Hu.TBLBasedLearing.model;

/**
 * <pre>
 * <b>接口数据封装类.</b>
 * </pre>
 * @author Administrator
 *
 */
public class Result {
	
	/** 业务处理响应码, 默认200成功. */
	private int code = 200;
	
	/** 响应的消息. */
	private String message;
	
	/** 请求响应的数据. */
	private Object data;
	
	public Result() {
	}

	public Result(int code){
		this.code = code;
	}

	public Result(int code, Object data) {
		super();
		this.code = code;
		this.data = data;
	}

	public Result(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public Result(int code, String message, Object data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public <T>T getData(Class<T> clazz){
		return null != data ? clazz.cast(data) : null;
	}
	
	public void setData(Object data) {
		this.data = data;
	}
	
	public boolean isSuccess(){
		return this.code == 200;
	}
	
}
