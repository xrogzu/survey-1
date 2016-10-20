package com.fire.survey.entities.guest;

import java.util.Set;

public class Bag {
	private Integer bagId;
	private String bagName;
	private int bagOrder;

	private Survey survey;
	private Set<Question> questionSet;

	
	public Set<Question> getQuestionSet() {
		return questionSet;
	}

	public void setQuestionSet(Set<Question> questionSet) {
		this.questionSet = questionSet;
	}

	public Integer getBagId() {
		return bagId;
	}

	public void setBagId(Integer bagId) {
		this.bagId = bagId;
	}

	public String getBagName() {
		return bagName;
	}

	public void setBagName(String bagName) {
		this.bagName = bagName;
	}

	public int getBagOrder() {
		return bagOrder;
	}

	public void setBagOrder(int bagOrder) {
		this.bagOrder = bagOrder;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	@Override
	public String toString() {
		return "Bag [bagId=" + bagId + ", bagName=" + bagName + ", bagOrder=" + bagOrder + ", survey=" + survey + "]";
	}

}
