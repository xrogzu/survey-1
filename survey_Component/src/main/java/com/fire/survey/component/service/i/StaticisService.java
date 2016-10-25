package com.fire.survey.component.service.i;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jfree.chart.JFreeChart;

public interface StaticisService {

	JFreeChart gnerateChart(Integer questionId);

	HSSFWorkbook createExcel(Integer surveyId);

}
