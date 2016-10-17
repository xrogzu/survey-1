package com.fire.survey.entities.guest;

public class User {
	private Integer id;
	private String name;
	private String password;
	private boolean company;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isCompany() {
		return company;
	}

	public void setCompany(boolean company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", company=" + company + "]";
	}

	public User(Integer id, String name, String password, boolean company) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.company = company;
	}

	public User() {
		super();
	}

}
