package com.fire.survey.component.handler.guest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fire.survey.component.service.i.QuestionService;
import com.fire.survey.component.service.i.SurveyService;
import com.fire.survey.entities.guest.Question;
import com.fire.survey.entities.guest.Survey;

@Controller
@RequestMapping("/question")
public class QuestionHandler {
	@Autowired
	private SurveyService surveyService;
	@Autowired
	private QuestionService questionService;

	@RequestMapping("/doUpdate/{surveyId}")
	public String doUpdate(Question question, @PathVariable("surveyId") Integer surveyId,
			Map<String, Object> map) {
		questionService.update(question);
		Survey survey = surveyService.getSurveyById(surveyId);
		map.put("survey", survey);
		return "guest/design_survey";
	}

	@RequestMapping("/update/{questionId}/{surveyId}")
	public String update(@PathVariable("questionId") Integer questionId, @PathVariable("surveyId") Integer surveyId,
			Map<String, Object> map) {
		Question question = questionService.getQuestion(questionId);
		map.put("question", question);
		return "guest/question_update";
	}

	@RequestMapping("/remove/{questionId}/{surveyId}")
	public String remove(@PathVariable("questionId") Integer questionId, @PathVariable("surveyId") Integer surveyId,
			Map<String, Object> map) {
		questionService.remove(questionId);
		Survey survey = surveyService.getSurveyById(surveyId);
		map.put("survey", survey);
		return "guest/design_survey";
	}

	@RequestMapping("/doAdd/{surveyId}")
	public String doAdd(Question question, @PathVariable("surveyId") Integer surveyId, Map<String, Object> map) {
		String ops = question.getOptions().replaceAll("\r\n", ",");
		question.setOptions(ops);
		questionService.save(question);
		Survey survey = surveyService.getSurveyById(surveyId);
		map.put("survey", survey);
		return "guest/design_survey";
	}

	@RequestMapping("/create/{bagId}/{surveyId}")
	public String add(@PathVariable("bagId") Integer bagId, @PathVariable("surveyId") Integer surveyId) {
		return "guest/question_add";
	}

}
