package com.fire.survey.component.handler.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fire.survey.component.service.i.AdminService;
import com.fire.survey.entities.manager.Admin;
import com.fire.survey.utils.DataProcess;

@Controller
@RequestMapping("/admin")
public class AdminHandler {

	@Autowired
	private AdminService adminService;

	@RequestMapping("/doLogin")
	public String doLogin(Admin admin, HttpSession session, HttpServletRequest request) {
		admin.setAdminPwd(DataProcess.md5(admin.getAdminPwd()));
		admin = adminService.login(admin);
		if (admin != null) {
			session.setAttribute("loginAdmin", admin);
			return "manage/mainUI";
		} else {
			request.setAttribute("message", "密码不正确");
			return "manage/manage_login";
		}
	}
	@RequestMapping("/logout")
	public String logout(Admin admin, HttpSession session) {
		session.invalidate();
		return "manage/manage_login";
	}

}
