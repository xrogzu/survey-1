package com.fire.survey.component.service.i;

import java.util.List;
import java.util.Map;

import com.fire.survey.entities.guest.Answer;

public interface AnswerService {

	void batchSave(Map<String, List<String>> ansMap);

	int getQuestionEngagedCount(Integer questionId);

	int getOptionEngagedCount(int opIndex, Integer questionId);

	int getSurveyEngageCount(Integer surveyId);

	List<Map<Integer, Answer>> createOneMap(Integer surveyId);


}
