package com.fire.survey.component.service.m;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fire.survey.component.dao.i.SurveyDao;
import com.fire.survey.component.service.i.SurveyService;
import com.fire.survey.entities.guest.Survey;
import com.fire.survey.entities.guest.User;
import com.fire.survey.utils.Page;

@Service
public class SurveyServiceImpl implements SurveyService {
	@Autowired
	private SurveyDao surveyDao;
	
	
	@Override
	public void save(String name, String path, User user) {
		Survey survey = new Survey();
		survey.setCompleted(false);
		survey.setName(name);
		if (path == null) {
			path = "pics/logo.png";
		}
		survey.setPicPath(path);
		survey.setUser(user);
		surveyDao.saveEntity(survey);
	}

	@Override
	public Page<Survey> getMyUnCompleted(User user, String pageNoStr) {
		int totalRecordNo = surveyDao.getMyUncompletedCount(user);
		Page<Survey> page = new Page<>(pageNoStr, totalRecordNo);
		List<Survey> list = surveyDao.getMyUncompletedList(user, page.getPageNo(), page.getPageSize());
		page.setList(list);
		return page;
	}

	@Override
	public void removieSurvey(Integer id) {
		surveyDao.removeEntityById(id);
	}

	@Override
	public Survey getSurveyById(Integer id) {
		return surveyDao.getEntityById(id);
	}

}
