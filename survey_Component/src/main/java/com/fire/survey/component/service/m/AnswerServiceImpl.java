package com.fire.survey.component.service.m;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fire.survey.component.dao.i.AnswerDao;
import com.fire.survey.component.service.i.AnswerService;
import com.fire.survey.entities.guest.Answer;

@Service
public class AnswerServiceImpl implements AnswerService {

	@Autowired
	private AnswerDao answerDao;

	@Override
	public void batchSave(Map<String, List<String>> ansMap) {
		Object[][] params = new Object[ansMap.size()][5];
		String uuid = UUID.randomUUID().toString();
		Set<String> keySet = ansMap.keySet();
		int i = 0;
		for (String key : keySet) {
			String[] strs = key.replaceAll("_op_", "").split("_");
			int surveyId = Integer.parseInt(strs[0]);
			int bagId = Integer.parseInt(strs[1]);
			int questionId = Integer.parseInt(strs[2]);
			StringBuilder sb = new StringBuilder();
			for (String str : ansMap.get(key)) {
				sb.append(str).append(",");
			}
			String content = sb.toString().replaceAll(",$", "");
			params[i] = new Object[] { surveyId, bagId, questionId, content, uuid };
			i++;
		}
		String sql = "insert into SURVEY_ANSWER(SURVEY_ID,BAG_ID,QUESTION_ID,CONTENT,UUID) VALUES (?,?,?,?,?) ";
		answerDao.batchUpdate(sql, params);
	}

	@Override
	public int getQuestionEngagedCount(Integer questionId) {
		String sql = "SELECT COUNT(content) FROM  `survey_answer` WHERE  content != \"\" AND content IS NOT NULL AND QUESTION_ID = ?";
		return answerDao.getCountBySql(sql, questionId);
	}

	@Override
	public int getOptionEngagedCount(int opIndex, Integer questionId) {
		String sql = "SELECT  COUNT(content) FROM `survey_answer` WHERE CONCAT(',',content,',') LIKE ?  AND QUESTION_ID = ?";
		return answerDao.getCountBySql(sql, "%," + opIndex + ",%", questionId);
	}

	@Override
	public int getSurveyEngageCount(Integer surveyId) {
		String hql = "Select count(*) From Answer s where s.surveyId = ?";
		return answerDao.getCountByHql(hql, surveyId);
	}

	/**
	 * 
	 * 获取问卷参与调查的集合 list中每个map为一次调查的结果，key为问题Id,Answer为相应的答案
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Map<Integer, Answer>> createOneMap(Integer surveyId) {
		String sql = "SELECT DISTINCT UUID FROM `survey_answer` WHERE SURVEY_ID = ?";
		List<String> uuids = (List<String>) answerDao.getListBySql(sql, surveyId);
		if (uuids == null || uuids.isEmpty()) {
			return null;
		}
		List<Map<Integer, Answer>> oneMap = new ArrayList<>();
		for (int i = 0; i < uuids.size(); i++) {
			String hql = "FROM Answer s where s.uuid = ?";
			List<Answer> ans = answerDao.getListByHql(hql, uuids.get(i));
			if (ans == null || ans.isEmpty()) {
				continue;
			}
			Map<Integer, Answer> map = new LinkedHashMap<>();
			for (Answer answer : ans) {
				map.put(answer.getQuestionId(), answer);
			}
			oneMap.add(map);
		}
		return oneMap;
	}
}
