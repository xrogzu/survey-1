package com.fire.survey.component.service.m;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fire.survey.component.dao.i.QuestionDao;
import com.fire.survey.component.service.i.QuestionService;
import com.fire.survey.entities.guest.Question;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionDao questionDao;

	public void save(Question question) {
		questionDao.saveEntity(question);
	}

	@Override
	public void remove(Integer questionId) {
		questionDao.removeEntityById(questionId);
	}

	@Override
	public Question getQuestion(Integer questionId) {
		return questionDao.getEntityById(questionId);
	}

	@Override
	public void update(Question question) {
		questionDao.updateEntity(question);
	}


}
