package com.fire.survey.tinterceptors;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.resource.DefaultServletHttpRequestHandler;

import com.fire.survey.utils.ConstanName;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	private Set<String> set = new HashSet<>();
	{
		set.add("/user/login");
		set.add("/user/regist");
		set.add("/manager/admin/toMainUI");
		set.add("/user/doLogin");
		set.add("/user/doRegist");
		set.add("/user/logout");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (handler instanceof DefaultServletHttpRequestHandler) {
			return true;
		}
		String path = request.getServletPath();
		if (set.contains(path)) {
			return true;
		}
		if (request.getSession().getAttribute(ConstanName.LOGIN_USER) != null) {
			return true;
		}
		return false;
	}
}
