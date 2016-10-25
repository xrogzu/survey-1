package com.fire.survey.component.service.m;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fire.survey.component.dao.i.AdminDao;
import com.fire.survey.component.service.i.AdminService;
import com.fire.survey.entities.manager.Admin;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;

	@Override
	public Admin login(Admin admin) {
		String hql = "FROM Admin a where a.adminName = ? and a.adminPwd = ?";
		return adminDao.getEntityByHql(hql, admin.getAdminName(), admin.getAdminPwd());
	}

}
