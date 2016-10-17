package com.fire.survey.test;

import org.junit.Test;

import com.fire.survey.utils.DataProcess;

/**
 * Spring 拦截器 prehandle 控制页面的转发
 * 
 * @author jiang
 *
 */
public class TestUtils {
	@Test
	public void test1() {
		System.out.println(DataProcess.md5("AAA"));
	}
}
