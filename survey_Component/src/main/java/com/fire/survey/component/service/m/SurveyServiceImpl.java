package com.fire.survey.component.service.m;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fire.survey.component.dao.i.SurveyDao;
import com.fire.survey.component.service.i.SurveyService;
import com.fire.survey.entities.guest.Bag;
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
	public void removieSurvey(Survey survey) {
		surveyDao.removeEntity(survey);
	}

	@Override
	public Survey getSurveyById(Integer id) {
		return surveyDao.getEntityById(id);
	}

	@Override
	public void updateSurvey(Survey survey) {
		surveyDao.updateSurvey(survey);
	}

	@Override
	public boolean doComplete(Integer surveyId) {
		Survey survey = surveyDao.getEntityById(surveyId);
		if (survey.getBagSet() == null || survey.getBagSet().size() == 0) {
			return false;
		}
		for (Bag bag : survey.getBagSet()) {
			if (bag.getQuestionSet() == null || bag.getQuestionSet().size() == 0) {
				return false;
			}
		}
		survey.setCompleted(true);
		return true;
	}

	@Override
	public Page<Survey> getAllCompletedSurvey(String pageStr) {
		int count = surveyDao.getCompletedCount();
		Page<Survey> page = new  Page<>(pageStr, count);
		List<Survey> list = surveyDao.getLimitedCompletedSurvey(page.getPageNo(),page.getPageSize());
		page.setList(list);
		return page;
	}

}
