package com.fire.survey.entities.guest;

import java.util.Set;

public class Survey {
	private Integer id;
	private String name;
	private boolean completed;
	private String picPath = "resources/logo.png";
	private User user;
	private Set<Bag> bagSet;

	public Integer getId() {
		return id;
	}

	public Set<Bag> getBagSet() {
		return bagSet;
	}

	public void setBagSet(Set<Bag> bagSet) {
		this.bagSet = bagSet;
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

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Survey [id=" + id + ", name=" + name + ", completed=" + completed + ", picPath=" + picPath + "]";
	}

}
