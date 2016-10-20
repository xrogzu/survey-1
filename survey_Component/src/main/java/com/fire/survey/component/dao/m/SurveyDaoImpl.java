package com.fire.survey.component.dao.m;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fire.survey.base.m.BaseDaoImpl;
import com.fire.survey.component.dao.i.SurveyDao;
import com.fire.survey.entities.guest.Survey;
import com.fire.survey.entities.guest.User;

@Repository
public class SurveyDaoImpl extends BaseDaoImpl<Survey> implements SurveyDao {

	@Override
	public List<Survey> getAllSurvey(User user) {
		String hql = "From Survey s where s.user = ? order by s.id desc";
		return getListByHql(hql, user);
	}

	@Override
	public List<Survey> getMyUncompletedList(User user, int pageNo, int pageSize) {
		String hql = "FROM Survey s WHERE s.user = ? AND s.completed = false order by s.id desc";
		return getLimitedListByHql(hql, pageNo, pageSize, user);
	}

	@Override
	public int getMyUncompletedCount(User user) {
		String hql = "SELECT COUNT(*) FROM Survey s WHERE s.user = ? AND s.completed = false";
		return getCountByHql(hql, user);
	}

	@Override
	public void updateSurvey(Survey survey) {
		String hql = "UPDATE Survey s SET s.name = ?,s.picPath = ? WHERE s.id = ? ";
		updateEntityByHql(hql, survey.getName(), survey.getPicPath(), survey.getId());
	}

}
