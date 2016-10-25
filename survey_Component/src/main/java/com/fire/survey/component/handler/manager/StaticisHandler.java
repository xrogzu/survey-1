package com.fire.survey.component.handler.manager;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fire.survey.component.service.i.StaticisService;
import com.fire.survey.component.service.i.SurveyService;
import com.fire.survey.entities.guest.Survey;
import com.fire.survey.utils.Page;

@Controller
@RequestMapping("/manage/staticis")
public class StaticisHandler {
	@Autowired
	private SurveyService surveyService;
	@Autowired
	private StaticisService staticisService;

	@RequestMapping("/outline/{surveyId}")
	public String generateoutline(@PathVariable("surveyId") Integer surveyId, Map<String, Object> map) {
		Survey survey = surveyService.getSurveyById(surveyId);
		map.put("survey", survey);
		return "manage/survey_details";
	}

	@RequestMapping("/chart/{questionId}")
	public void generateChart(@PathVariable("questionId") Integer questionId, HttpServletResponse response)
			throws IOException {
		JFreeChart jFreeChart = staticisService.gnerateChart(questionId);
		// response.setContentType("image/jpeg");
		// response.setHeader("Content-Disposition", "attachment;filename=" +
		// System.nanoTime() + ".jpg");
		ServletOutputStream out = response.getOutputStream();
		ChartUtilities.writeChartAsJPEG(out, jFreeChart, 800, 600);
	}

	@RequestMapping("/excel/{surveyId}")
	public void generateExcel(@PathVariable("surveyId") Integer surveyId, HttpServletResponse response) throws IOException {
		HSSFWorkbook workbook = staticisService.createExcel(surveyId);
		response.setContentType("application/vnd.ms-excel");

		// 3.组装文件名
		String fileName = System.nanoTime() + ".xls";

		// 4.设置响应消息头，目的是让浏览器能够识别到文件名
		response.setHeader("Content-Disposition", "attachment;filename=" + fileName);

		// 5.获取字节输出流对象
		ServletOutputStream outputStream = response.getOutputStream();

		// 6.将工作表数据写入输出流
		workbook.write(outputStream);
	}

	@RequestMapping("/Survey")
	public String SimpleDigest(@RequestParam(value = "pageStr", required = false) String pageStr,
			HttpServletRequest req) {

		Page<Survey> page = surveyService.getAllCompletedSurvey(pageStr);
		req.setAttribute("page", page);
		return "manage/staticis_surveyInfo";
	}
}
