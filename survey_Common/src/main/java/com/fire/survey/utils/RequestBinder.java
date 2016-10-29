package com.fire.survey.utils;

import javax.servlet.http.HttpServletRequest;

public class RequestBinder {
	private static ThreadLocal<HttpServletRequest> local = new ThreadLocal<>();

	public static void bind(HttpServletRequest request) {
		local.set(request);
	}

	public static void remove() {
		local.remove();
	}

	public static HttpServletRequest getRequest() {
		return local.get();
	}
}
