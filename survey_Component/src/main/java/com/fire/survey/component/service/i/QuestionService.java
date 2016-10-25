package com.fire.survey.component.service.i;

import com.fire.survey.entities.guest.Question;

public interface QuestionService {

	void save(Question question);

	void remove(Integer questionId);

	Question getQuestion(Integer questionId);

	void update(Question question);


}
