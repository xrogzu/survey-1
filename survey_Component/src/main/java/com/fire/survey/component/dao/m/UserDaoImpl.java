package com.fire.survey.component.dao.m;

import org.springframework.stereotype.Repository;

import com.fire.survey.base.m.BaseDaoImpl;
import com.fire.survey.component.dao.i.UserDao;
import com.fire.survey.entities.guest.User;
import com.fire.survey.utils.DataProcess;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public User login(User user) {
		String hql = "From User u where u.name = ? and u.password = ?";
		return getEntityByHql(hql, user.getName(), DataProcess.md5(user.getPassword()));
	}

	@Override
	public boolean checkName(String name) {
		String sql = "select count(*) From guest_User u where u.name = ?  ";
		return getCountBySql(sql, name) > 0;
	}

	@Override
	public void regist(User user) {

		user.setPassword(DataProcess.md5(user.getPassword()));

		saveEntity(user);
	}

}
