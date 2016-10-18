package com.fire.survey.test;

import org.junit.Test;

public class TestPic {

	@Test
	public void test1() {
		String pic = "wewe/dsd/a.png";
		String substring = pic.substring(pic.lastIndexOf(".")+1);
		System.out.println(substring);
	}
}
