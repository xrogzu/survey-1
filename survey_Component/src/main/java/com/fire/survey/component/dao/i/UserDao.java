package com.fire.survey.component.dao.i;

import com.fire.survey.base.i.BaseDao;
import com.fire.survey.entities.guest.User;

public interface UserDao extends BaseDao<User>{
	User login(User user);

	boolean checkName(String name);

	void regist(User user);

}
