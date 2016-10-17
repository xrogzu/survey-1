package com.fire.survey.component.service.i;

import com.fire.survey.entities.guest.User;

public interface UserService{

	User login(User user);

	void regist(User user);


	boolean checkName(String name);
}
