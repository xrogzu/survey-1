package com.fire.survey.component.service.i;

import com.fire.survey.entities.guest.Survey;
import com.fire.survey.entities.guest.User;
import com.fire.survey.utils.Page;

public interface SurveyService {

	void save(String name, String path, User user);

	Page<Survey> getMyUnCompleted(User user, String pageNoStr);

	void removieSurvey(Survey survey);

	Survey getSurveyById(Integer id);

	void updateSurvey(Survey survey);

}
