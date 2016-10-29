package com.fire.survey.component.service.m;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fire.survey.component.dao.i.SLogDao;
import com.fire.survey.component.service.i.SLogService;
import com.fire.survey.entities.guest.SLog;

@Service
public class SLogServiceImpl implements SLogService {
	@Autowired
	private SLogDao sLogDao;

	@Override
	public void save(SLog sLog) {
		sLogDao.saveEntity(sLog);
	}

	@Override
	public void createTable(String tableName) {
		sLogDao.createTable(tableName);
	}

}
