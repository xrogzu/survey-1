package com.fire.survey.component.service.i;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fire.survey.base.m.BaseDaoImpl;
import com.fire.survey.component.dao.i.ResDao;
import com.fire.survey.entities.manager.Res;

@Repository
public class ResDaoImpl extends BaseDaoImpl<Res> implements ResDao {

	@Override
	public boolean containsPath(String path) {
		String hql = "Select count(*) From Res r where r.servletPath = ?";
		int count = getCountByHql(hql, path);
		return count > 0;
	}

	@Override
	public Integer getMaxPos() {
		String hql = "Select max(r.resPos) from Res r";
		return (Integer) getQuery(hql).uniqueResult();
	}

	@Override
	public Integer getMaxCode(Integer maxPos) {
		String hql = "Select max(r.resCode) from Res r where r.resPos = ?";
		return (Integer) getQuery(hql, maxPos).uniqueResult();
	}

	@Override
	public List<Res> getAllRes() {
		String hql = "From Res";
		return getListByHql(hql);
	}


}
