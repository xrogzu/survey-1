package com.fire.survey.router;

public class RouterKeyBinder {
	private static ThreadLocal<String> local = new ThreadLocal<>();

	public static void bindKey(String key) {
		local.set(key);
	}

	public static void removeKey() {
		local.remove();
	}

	public static String getKey() {
		return local.get();
	}
}
