package com.fire.survey.component.dao.m;

import org.springframework.stereotype.Repository;

import com.fire.survey.base.m.BaseDaoImpl;
import com.fire.survey.component.dao.i.SLogDao;
import com.fire.survey.entities.guest.SLog;

@Repository
public class SLogDaoImpl extends BaseDaoImpl<SLog> implements SLogDao {

	@Override
	public void createTable(String tableName) {
		String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " LIKE	`survey_slog`";
		getSqlQuery(sql).executeUpdate();
	}

}
