package com.fire.survey.component.dao.i;

import java.util.List;

import com.fire.survey.base.i.BaseDao;
import com.fire.survey.entities.manager.Res;

public interface ResDao extends BaseDao<Res> {

	boolean containsPath(String path);

	Integer getMaxPos();

	Integer getMaxCode(Integer maxPos);

	List<Res> getAllRes();


}
