package com.fire.survey.entities.manager;

public class Admin {
	private Integer adminId;
	private String adminName;
	private String adminPwd;

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPwd() {
		return adminPwd;
	}

	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}

	public Admin(String adminName, String adminPwd) {
		super();
		this.adminName = adminName;
		this.adminPwd = adminPwd;
	}

	public Admin() {
		super();
	}

}
