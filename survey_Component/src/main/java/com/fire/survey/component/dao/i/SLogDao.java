package com.fire.survey.component.dao.i;

import com.fire.survey.base.i.BaseDao;
import com.fire.survey.entities.guest.SLog;

public interface SLogDao extends BaseDao<SLog>{

	void createTable(String tableName);

}
