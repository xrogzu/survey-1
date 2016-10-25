package com.fire.survey.component.dao.i;

import java.util.List;

import com.fire.survey.base.i.BaseDao;
import com.fire.survey.entities.guest.Survey;
import com.fire.survey.entities.guest.User;

public interface SurveyDao extends BaseDao<Survey>{
	

	List<Survey> getAllSurvey(User user);
	
	List<Survey> getMyUncompletedList(User user, int pageNo, int pageSize);
	
	int getMyUncompletedCount(User user);

	void updateSurvey(Survey survey);

	int getCompletedCount();

	List<Survey> getLimitedCompletedSurvey(int pageNo, int pageSize);

}
