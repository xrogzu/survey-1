package com.fire.survey.component.service.m;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fire.survey.component.dao.i.ResDao;
import com.fire.survey.component.service.i.ResService;
import com.fire.survey.entities.manager.Res;
import com.fire.survey.utils.DataProcess;

@Service
public class ResServiceImpl implements ResService {

	@Autowired
	private ResDao resDao;

	@Override
	public void savePath(String path) {
		path = DataProcess.pathHandler(path);
		boolean b = resDao.containsPath(path);
		if (b) {
			return;
		}
		Integer resPos = null;
		Integer resCode = null;
		Integer maxPos = resDao.getMaxPos();
		if (maxPos == null) {
			resPos = 0;
			resCode = 1;// 保存第一个参数
		} else {
			Integer maxCode = resDao.getMaxCode(maxPos);
			if (maxCode == (1 << 30)) {
				resPos = maxPos + 1;
				resCode = 1;
			} else {
				resPos = maxPos;
				resCode = maxCode << 1;
			}

		}

		Res res = new Res(null, path, resCode, resPos, false);
		resDao.saveEntity(res);

	}

	@Override
	public List<Res> getResList() {
		return resDao.getAllRes();
	}

	@Override
	public boolean remove(Integer resId) {
		Res res = resDao.getEntityById(resId);
		res.setPublicStatus(!res.isPublicStatus());
		return res.isPublicStatus();
	}

}
