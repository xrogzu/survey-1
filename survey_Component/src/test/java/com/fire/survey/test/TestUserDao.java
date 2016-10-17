package com.fire.survey.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fire.survey.component.dao.i.UserDao;
import com.fire.survey.entities.guest.User;

public class TestUserDao {
	ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-Context.xml");
	UserDao dao = ioc.getBean(UserDao.class);

	@Test
	public void test4() {
		dao.checkName("aaaa");
	}

	@Test
	public void test3() {
		dao.regist(new User(null, "jack", "123321", false));
	}

	@Test
	public void test2() {
		User user = dao.login(new User(null, "jack", "123321", false));
		System.out.println(user);
	}

	@Test
	public void test1() {
		System.out.println(dao.checkName("Charlie"));
	}
}
