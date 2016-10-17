package com.fire.survey.component.handler.guest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fire.survey.component.service.i.UserService;
import com.fire.survey.entities.guest.User;
import com.fire.survey.utils.ConstanName;

@Controller
@RequestMapping("/user")
public class UserHandler {

	@Autowired
	private UserService userService;

	@RequestMapping("/doLogin")
	public String doLogin(User user, HttpServletRequest request) {
		user = userService.login(user);
		if (user == null) {
			request.setAttribute("message", "用户名或密码不正确！");
			return "guest/user_login";
		}
		request.getSession().setAttribute(ConstanName.LOGIN_USER, user);
		return "redirect:/index.jsp";
	}

	@RequestMapping("/doRegist")
	public String doRegist(User user, HttpServletRequest request) {
		if (userService.checkName(user.getName())) {
			request.setAttribute("message", "用户名已经被注册！");
			return "guest/user_regist";
		} else {
			userService.regist(user);
		}
		return "guest/user_login";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/index.jsp";
	}

}
