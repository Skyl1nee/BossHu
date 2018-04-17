package com.Hu.TBLBasedLearing.utils;

import javax.servlet.http.HttpServletRequest;

/***
 * Web操作的常量类
 * @author Administrator
 *
 */
public abstract class WebKeys {
	
	/** 用户会话中存放用户信息的KEY. */
	public static final String USER_SESSION_KEY = "SESSION_USER";
	
	public static String getContextPath(HttpServletRequest request){
		return request.getContextPath();
	}
	
}
