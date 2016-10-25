package com.fire.survey.tinterceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.resource.DefaultServletHttpRequestHandler;

import com.fire.survey.component.service.i.ResService;

public class PathAddInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private ResService resService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(handler instanceof DefaultServletHttpRequestHandler){
			return true;
		}
		String path = request.getServletPath();
		resService.savePath(path);
		return true;
	}
}
