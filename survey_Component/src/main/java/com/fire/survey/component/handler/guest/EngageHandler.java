package com.fire.survey.component.handler.guest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fire.survey.component.service.i.AnswerService;
import com.fire.survey.component.service.i.SurveyService;
import com.fire.survey.entities.guest.Bag;
import com.fire.survey.entities.guest.Survey;
import com.fire.survey.utils.Page;

@Controller
@RequestMapping("/engage")
public class EngageHandler {
	
	@Autowired
	private AnswerService answerService;
	@Autowired
	private SurveyService surveyService;

	@RequestMapping("doSurvey")
	public String engageDoing(@RequestParam("currentIndex") Integer currentIndex, HttpSession session,
			HttpServletRequest request) {

		Map<String, String[]> parameterMap = request.getParameterMap();
		@SuppressWarnings("unchecked")
		Map<String, List<String>> ansMap = (Map<String, List<String>>) session.getAttribute("ansMap");
		Set<String> keySet = parameterMap.keySet();
		if (keySet.contains("p_abort")) {
			cleanSession(session);
			return "redirect:/index.jsp";
		} else if (keySet.contains("p_commit")) {
			cleanSession(session);
			copyData(parameterMap, ansMap);
			commit(ansMap);
			return "redirect:/index.jsp";
		} else if (keySet.contains("p_next")) {
			currentIndex++;
		} else if (keySet.contains("p_prev")) {
			currentIndex--;
		}
		copyData(parameterMap, ansMap);
		Survey survey = (Survey) session.getAttribute("survey");
		List<Bag> list = new ArrayList<>(survey.getBagSet());
		request.setAttribute("bag", list.get(currentIndex));
		request.setAttribute("currentIndex", currentIndex);
		return "guest/engage_complete";
	}

	@RequestMapping("survey/{surveyId}")
	public String engageStart(@PathVariable("surveyId") Integer surveyId, HttpSession session,
			HttpServletRequest request) {
		Survey survey = surveyService.getSurveyById(surveyId);
		List<Bag> list = new ArrayList<>(survey.getBagSet());
		request.setAttribute("bag", list.get(0));
		request.setAttribute("currentIndex", 0);
		session.setAttribute("survey", survey);
		Map<String, List<String>> ansMap = new LinkedHashMap<>();
		session.setAttribute("ansMap", ansMap);
		session.setAttribute("totalIndex", list.size());
		return "guest/engage_complete";
	}

	@RequestMapping("/showAllAviabelSurvey")
	public String showAllAviabelSurvey(@RequestParam(value = "pageStr", required = false) String pageStr,
			Map<String, Object> map) {
		Page<Survey> page = surveyService.getAllCompletedSurvey(pageStr);
		map.put("page", page);
		return "guest/engage_showAll";
	}

	private void commit(Map<String, List<String>> ansMap) {
		answerService.batchSave(ansMap);
	}

	private void cleanSession(HttpSession session) {
		session.removeAttribute("survey");
		session.removeAttribute("totalIndex");
		session.removeAttribute("ansMap");
	}

	private void copyData(Map<String, String[]> parameterMap, Map<String, List<String>> ansMap) {
		Set<String> keySet = parameterMap.keySet();
		for (String key : keySet) {
			if (key != null && key.trim().startsWith("_op_")) {
				ansMap.put(key.trim(), Arrays.asList(parameterMap.get(key)));
			}
		}
	}

}
