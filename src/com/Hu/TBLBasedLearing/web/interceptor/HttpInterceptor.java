package com.Hu.TBLBasedLearing.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.Hu.TBLBasedLearing.utils.WebKeys;

public class HttpInterceptor implements HandlerInterceptor{


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object hander) throws Exception {
		return true;
	}


	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object hander, ModelAndView view)
			throws Exception {
		if(null != view){
			view.addObject("contextPath", WebKeys.getContextPath(request));
			view.addObject("cssPath", WebKeys.getContextPath(request) + "/css");
			view.addObject("jsPath", WebKeys.getContextPath(request) + "/js");
		}
	}

	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object hander, Exception ex)
			throws Exception {
		
	}
}
