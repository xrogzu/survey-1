package com.fire.survey.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fire.survey.component.dao.m.UserDaoImpl;
import com.fire.survey.entities.guest.User;

public class TestBaseDao {
	ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-Context.xml");
	UserDaoImpl dao = ioc.getBean(UserDaoImpl.class);

	@Test
	public void test5() {
		String sql = "update guest_user   set name = ? where id = ?"; // success
		dao.updateEntityBySql(sql, "ddd", 2);
	}

	@Test
	public void test4() {
		// dao.updateEntity(new User(2, "BBBB", null, false));//failed
		String hql = "update User u set u.name = ? where u.id = ?"; // success
		dao.updateEntityByHql(hql, "ccc", 2);
	}

	@Test // failed
	public void test3() {
		dao.removeEntity(new User(2, null, null, false));
	}

	@Test
	public void test2() {
		dao.removeEntityById(1);
	}

	@Test
	public void test1() {
		dao.saveEntity(new User(null, "AA", "1233321", true));
	}
}
