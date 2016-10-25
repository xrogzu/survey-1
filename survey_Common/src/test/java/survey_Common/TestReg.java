package survey_Common;

import org.junit.Test;

public class TestReg {

	@Test
	public void test3() {
		System.out.println(1 <<1);
		System.out.println(1 << 30);
		System.out.println(1 << 31);
	}
	///engage/survey/16
	@Test
	public void test2() {
		String str = "/survey/doDelete/10/1";
		String regex = "/\\d.*$";
		System.out.println(str.replaceAll(regex, ""));
	}

	@Test
	public void test1() {
		String str = "1\n\r2\n\r3";
		System.out.println(str);
		System.out.println(str.replaceAll("\n\r", ","));
	}

}
