package com.fire.survey.component.service.i;

import java.util.List;

import com.fire.survey.entities.manager.Res;

public interface ResService {

	void savePath(String path);

	List<Res> getResList();

	boolean remove(Integer resId);

}
