package com.fire.survey.component.service.m;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fire.survey.component.dao.i.UserDao;
import com.fire.survey.component.service.i.UserService;
import com.fire.survey.entities.guest.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User login(User user) {
		return userDao.login(user);
	}

	@Override
	public void regist(User user) {
		userDao.regist(user);
	}

	@Override
	public boolean checkName(String name) {
		return userDao.checkName(name);
	}

}
