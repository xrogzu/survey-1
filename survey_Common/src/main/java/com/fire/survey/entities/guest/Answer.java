package com.fire.survey.entities.guest;

public class Answer {
	private Integer answerId;
	private String content;
	private String uuid;
	private Integer surveyId;
	private Integer questionId;
	private Integer bagId;
	
	
	public Integer getBagId() {
		return bagId;
	}

	public void setBagId(Integer bagId) {
		this.bagId = bagId;
	}

	public Integer getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Integer answerId) {
		this.answerId = answerId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Integer getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Integer surveyId) {
		this.surveyId = surveyId;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	
	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", content=" + content + ", uuid=" + uuid + ", surveyId=" + surveyId
				+ ", questionId=" + questionId + ", bagId=" + bagId + "]";
	}

	public Answer(Integer answerId, String content, String uuid, Integer surveyId, Integer questionId, Integer bagId) {
		super();
		this.answerId = answerId;
		this.content = content;
		this.uuid = uuid;
		this.surveyId = surveyId;
		this.questionId = questionId;
		this.bagId = bagId;
	}

	public Answer() {
		super();
	}

}
