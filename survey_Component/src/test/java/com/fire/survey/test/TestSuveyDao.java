package com.fire.survey.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fire.survey.component.dao.i.SurveyDao;
import com.fire.survey.entities.guest.Survey;
import com.fire.survey.entities.guest.User;

public class TestSuveyDao {
	ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-Context.xml");
	SurveyDao dao = ioc.getBean(SurveyDao.class);

	@Test
	public void test3() {
		User user = new User();
		user.setId(4);
		List<Survey> myUncompletedList = dao.getMyUncompletedList(user, 2, 4);
		for (Survey survey : myUncompletedList) {
			System.out.println(survey);
		}

	}

	@Test
	public void test2() {
		User user = new User();
		user.setId(4);
		int count = dao.getMyUncompletedCount(user);
		System.out.println(count);
	}

	@Test
	public void test1() {

		User user = new User();
		user.setId(7);
		List<Survey> allSurvey = dao.getAllSurvey(user);
		for (Survey survey : allSurvey) {
			System.out.println(survey);
		}
	}
}
