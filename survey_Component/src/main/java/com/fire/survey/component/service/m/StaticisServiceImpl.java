package com.fire.survey.component.service.m;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fire.survey.component.service.i.AnswerService;
import com.fire.survey.component.service.i.QuestionService;
import com.fire.survey.component.service.i.StaticisService;
import com.fire.survey.component.service.i.SurveyService;
import com.fire.survey.entities.guest.Answer;
import com.fire.survey.entities.guest.Bag;
import com.fire.survey.entities.guest.Question;
import com.fire.survey.entities.guest.Survey;

@Service
public class StaticisServiceImpl implements StaticisService {
	@Autowired
	private AnswerService answerService;
	@Autowired
	private SurveyService surveyService;
	@Autowired
	private QuestionService questionService;

	@Override
	public JFreeChart gnerateChart(Integer questionId) {
		DefaultPieDataset dataset = new DefaultPieDataset();
		Question question = questionService.getQuestion(questionId);
		int qcount = answerService.getQuestionEngagedCount(questionId);
		String title = question.getQuestionName() + "(" + qcount + "参与)";
		String[] options = question.getShowOptions();
		for (int i = 0; i < options.length; i++) {
			int opCount = answerService.getOptionEngagedCount(i, questionId);
			dataset.setValue(options[i], opCount);
		}
		JFreeChart jFreeChart = ChartFactory.createPieChart(title, dataset);

		// 设置表格标题
		jFreeChart.getTitle().setFont(new Font("宋体", Font.BOLD, 25));
		// 设置图例格式
		jFreeChart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 25));
		// 设置绘图区
		PiePlot plot = (PiePlot) jFreeChart.getPlot();
		plot.setLabelFont(new Font("宋体", Font.PLAIN, 20));
		// 标签显示格式的设置
		// {0}：标签名
		// {1}：当前标签自身的数值
		// {2}：百分比
		// {3}：总数
		plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0},{1}/{3},{2}"));
		return jFreeChart;
	}

	@Override
	public HSSFWorkbook createExcel(Integer surveyId) {
		HSSFWorkbook workbook = new HSSFWorkbook();
		Survey survey = surveyService.getSurveyById(surveyId);
		String title = survey.getName() + "(共计" + answerService.getSurveyEngageCount(surveyId) + "人次参与调查)";
		HSSFSheet sheet = workbook.createSheet(title);
		HSSFRow rowHead = sheet.createRow(0);
		List<Integer> qIdList = new ArrayList<>(); // 记录每一行questionId值
		Set<Bag> bagSet = survey.getBagSet();
		for (Bag bag : bagSet) {
			Set<Question> questionSet = bag.getQuestionSet();
			for (Question question : questionSet) {
				HSSFCell cell = rowHead.createCell(qIdList.size());
				cell.setCellValue(question.getQuestionName());
				qIdList.add(question.getQuestionId());
			}
		}
		List<Map<Integer, Answer>> oneMap = answerService.createOneMap(surveyId);
		int count = 0;
		for (Map<Integer, Answer> map : oneMap) {
			HSSFRow row = sheet.createRow(++count);
			for (int i = 0; i < qIdList.size(); i++) {
				HSSFCell cell = row.createCell(i);
				int index = qIdList.get(i);
				String value = map.get(index).getContent();
				cell.setCellValue(value);
			}

		}
		return workbook;
	}

}
