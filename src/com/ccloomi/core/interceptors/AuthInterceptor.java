package com.ccloomi.core.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AuthInterceptor implements HandlerInterceptor{
	private final Logger log=LoggerFactory.getLogger(this.getClass());
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object obj)throws Exception {
		log.debug("Request: {}",request.getRequestURL());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,HttpServletResponse response, Object obj,ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,HttpServletResponse response, Object obj,Exception e) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
